package com.thoughtworks.dddworkshop.domain.command.handler;

import com.thoughtworks.dddworkshop.domain.command.PerformPayment;
import com.thoughtworks.dddworkshop.domain.command.validation.PerformPaymentValidator;
import com.thoughtworks.dddworkshop.domain.entity.PaymentEventRepository;
import com.thoughtworks.dddworkshop.domain.event.PaymentRequested;
import com.thoughtworks.dddworkshop.domain.shared.CommandFailure;
import com.thoughtworks.dddworkshop.domain.shared.CommandHandler;
import com.thoughtworks.dddworkshop.domain.vo.PaymentEventId;
import com.thoughtworks.dddworkshop.domain.vo.PaymentId;
import com.thoughtworks.dddworkshop.infrastructure.util.i18n.I18nCode;
import io.vavr.control.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static io.vavr.control.Either.left;
import static java.util.concurrent.CompletableFuture.completedFuture;

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

        //TODO: implement here
        return performPaymentValidator.acceptOrReject(command).fold(
                reject -> CompletableFuture.completedFuture(Either.left(reject)),
                accept -> completedFuture(left(new CommandFailure(new HashSet<I18nCode>() {{
                    add(new I18nCode("SERVICE_UNAVAILABLE"));
                }}))));
    }
}