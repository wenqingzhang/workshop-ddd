package com.thoughtworks.dddworkshop.domain.command.handler;

import com.thoughtworks.dddworkshop.domain.command.PerformPayment;
import com.thoughtworks.dddworkshop.domain.command.validation.PerformPaymentValidator;
import com.thoughtworks.dddworkshop.domain.entity.PaymentEventRepository;
import com.thoughtworks.dddworkshop.domain.event.PaymentRequested;
import com.thoughtworks.dddworkshop.domain.shared.CommandFailure;
import com.thoughtworks.dddworkshop.domain.shared.CommandHandler;
import com.thoughtworks.dddworkshop.domain.vo.PaymentEventId;
import com.thoughtworks.dddworkshop.domain.vo.PaymentId;
import io.vavr.control.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Component
public class PerformPaymentHandler implements
        CommandHandler<PerformPayment, PaymentRequested, PaymentId> {

    private static final Logger LOG = LoggerFactory.getLogger(PerformPaymentHandler.class);

    private final PaymentEventRepository paymentEventRepository;
    private final PerformPaymentValidator performPaymentValidator;

    PerformPaymentHandler(PaymentEventRepository paymentEventRepository,
                          PerformPaymentValidator performPaymentValidator) {
        this.paymentEventRepository = paymentEventRepository;
        this.performPaymentValidator = performPaymentValidator;
    }

    @Override
    public CompletionStage<Either<CommandFailure, PaymentRequested>> handle(PerformPayment command, PaymentId entityId) {

        LOG.debug("Handle command {}", command);

        return performPaymentValidator.acceptOrReject(command).fold(
                reject -> CompletableFuture.completedFuture(Either.left(reject)),
                accept -> {
                    PaymentRequested event = PaymentRequested.eventOf(
                            entityId,
                            command.getCustomerId(),
                            command.getPaymentIntent(),
                            command.getPaymentMethod(),
                            command.getTransaction(),
                            command.getTimestamp()
                    );
                    CompletionStage<PaymentEventId> storePromise = paymentEventRepository.store(event);
                    return storePromise.thenApply(paymentEventId -> Either.right(event));
                }
        );
    }


}