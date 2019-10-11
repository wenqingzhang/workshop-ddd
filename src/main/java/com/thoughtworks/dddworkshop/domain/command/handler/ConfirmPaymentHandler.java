package com.thoughtworks.dddworkshop.domain.command.handler;

import com.thoughtworks.dddworkshop.domain.command.ConfirmPayment;
import com.thoughtworks.dddworkshop.domain.entity.PaymentEventRepository;
import com.thoughtworks.dddworkshop.domain.event.PaymentConfirmed;
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
import java.util.concurrent.CompletionStage;

import static io.vavr.control.Either.left;
import static java.util.concurrent.CompletableFuture.completedFuture;

@Component
public class ConfirmPaymentHandler implements CommandHandler<ConfirmPayment, PaymentConfirmed, PaymentId> {

    private static final Logger LOG = LoggerFactory.getLogger(ConfirmPaymentHandler.class);

    private final PaymentEventRepository paymentEventRepository;


    public ConfirmPaymentHandler(PaymentEventRepository paymentEventRepository) {
        this.paymentEventRepository = paymentEventRepository;
    }

    @Override
    public CompletionStage<Either<CommandFailure, PaymentConfirmed>> handle(ConfirmPayment command, PaymentId entityId) {

        LOG.debug("Handle command {}", command);

        //TODO: implement here
        return completedFuture(left(new CommandFailure(new HashSet<I18nCode>() {{
            add(new I18nCode("SERVICE_UNAVAILABLE"));
        }})));
    }
}
