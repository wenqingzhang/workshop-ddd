package com.thoughtworks.dddworkshop.application.impl;

import com.thoughtworks.dddworkshop.application.PaymentProcessManager;
import com.thoughtworks.dddworkshop.domain.command.AuthorizePayment;
import com.thoughtworks.dddworkshop.domain.command.ConfirmPayment;
import com.thoughtworks.dddworkshop.domain.command.PerformPayment;
import com.thoughtworks.dddworkshop.domain.entity.Payment;
import com.thoughtworks.dddworkshop.domain.event.PaymentAuthorized;
import com.thoughtworks.dddworkshop.domain.event.PaymentConfirmed;
import com.thoughtworks.dddworkshop.domain.event.PaymentEvent;
import com.thoughtworks.dddworkshop.domain.event.PaymentRequested;
import com.thoughtworks.dddworkshop.domain.shared.CommandFailure;
import com.thoughtworks.dddworkshop.domain.vo.PaymentId;
import com.thoughtworks.dddworkshop.domain.vo.PaymentStatus;
import com.thoughtworks.dddworkshop.infrastructure.util.i18n.I18nCode;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.control.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;
import static java.util.concurrent.CompletableFuture.completedFuture;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
class PaymentProcessManagerImpl implements PaymentProcessManager {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentProcessManagerImpl.class);

    private final ApplicationContext applicationContext;

    PaymentProcessManagerImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public CompletionStage<Either<CommandFailure, Tuple2<PaymentId, PaymentStatus>>> process(PerformPayment performPayment) {

        LOG.debug("Payment process {}", performPayment);

        //TODO: implement here
        return completedFuture(left(new CommandFailure(new HashSet<I18nCode>() {{
            add(new I18nCode("SERVICE_UNAVAILABLE"));
        }})));
    }
}
