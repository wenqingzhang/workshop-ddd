package com.thoughtworks.dddworkshop.domain.command.handler;


import com.thoughtworks.dddworkshop.domain.command.AuthorizePayment;
import com.thoughtworks.dddworkshop.domain.command.validation.AuthorizePaymentValidator;
import com.thoughtworks.dddworkshop.domain.entity.PaymentEventRepository;
import com.thoughtworks.dddworkshop.domain.event.PaymentAuthorized;
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
public class AuthorizePaymentHandler implements CommandHandler<AuthorizePayment, PaymentAuthorized, PaymentId> {

    private static final Logger LOG = LoggerFactory.getLogger(AuthorizePaymentHandler.class);

    private final PaymentEventRepository paymentEventRepository;
    private final AuthorizePaymentValidator authorizePaymentValidator;


    public AuthorizePaymentHandler(PaymentEventRepository paymentEventRepository,
                                   AuthorizePaymentValidator authorizePaymentValidator) {
        this.paymentEventRepository = paymentEventRepository;
        this.authorizePaymentValidator = authorizePaymentValidator;
    }

    @Override
    public CompletionStage<Either<CommandFailure, PaymentAuthorized>> handle(AuthorizePayment command, PaymentId entityId) {

        LOG.debug("Handle command {}", command);

        //TODO: implement here
        return authorizePaymentValidator.acceptOrReject(command).fold(
                reject -> CompletableFuture.completedFuture(Either.left(reject)),
                accept -> completedFuture(left(new CommandFailure(new HashSet<I18nCode>() {{
                    add(new I18nCode("SERVICE_UNAVAILABLE"));
                }}))));
    }
}
