package com.thoughtworks.dddworkshop.business;

import com.thoughtworks.dddworkshop.business.bo.ProcessAuthorizedObject;
import com.thoughtworks.dddworkshop.business.bo.ProcessConfirmObject;
import com.thoughtworks.dddworkshop.business.bo.ProcessPaymentObject;
import com.thoughtworks.dddworkshop.persistence.po.PaymentAuthorized;
import com.thoughtworks.dddworkshop.persistence.po.PaymentConfirmed;
import com.thoughtworks.dddworkshop.persistence.po.PaymentEvent;
import com.thoughtworks.dddworkshop.persistence.po.PaymentRequested;
import com.thoughtworks.dddworkshop.persistence.repository.PaymentEventRepository;
import com.thoughtworks.dddworkshop.vo.*;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.control.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;
import static java.util.concurrent.CompletableFuture.completedFuture;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class PaymentProcessManager {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentProcessManager.class);

    private final PaymentEventRepository paymentEventRepository;

    public PaymentProcessManager(PaymentEventRepository paymentEventRepository) {
        this.paymentEventRepository = paymentEventRepository;
    }

    public CompletionStage<Either<ProcessFailure, Tuple2<PaymentId, PaymentStatus>>> process(
            ProcessPaymentObject paymentObject
    ) {

        LOG.debug("Payment process {}", paymentObject);

        PaymentId id = new PaymentId();

        return processPayment(id, paymentObject).thenCompose(paymentRequested -> paymentRequested.fold(
                rejectPayment -> completedFuture(left(rejectPayment)),
                acceptPayment -> processAuthorize(acceptPayment).thenCompose(paymentAuthorized -> paymentAuthorized.fold(
                        rejectAuthorization -> completedFuture(left(rejectAuthorization)),
                        acceptAuthorization -> {
                            if (acceptPayment.getPaymentIntent().isAuthorize()) {
                                return completedFuture(right(Tuple.of(acceptPayment.getPaymentId(), PaymentStatus.AUTHORIZED)));
                            } else {
                                return processConfirm(acceptPayment).thenApply(paymentConfirmed -> paymentConfirmed.fold(
                                        rejectConfirmation -> left(rejectConfirmation),
                                        acceptConfirmation -> right(Tuple.of(acceptPayment.getPaymentId(), PaymentStatus.CAPTURED))
                                ));
                            }
                        }))));
    }

    private CompletionStage<Either<ProcessFailure, PaymentRequested>> processPayment(
            PaymentId id,
            ProcessPaymentObject paymentObject) {
        return validatePayment(paymentObject).fold(
                reject -> CompletableFuture.completedFuture(Either.left(reject)),
                accept -> {
                    PaymentRequested event = PaymentRequested.eventOf(
                            id,
                            paymentObject.getCustomerId(),
                            paymentObject.getPaymentIntent(),
                            paymentObject.getPaymentMethod(),
                            paymentObject.getTransaction(),
                            paymentObject.getTimestamp()
                    );
                    CompletionStage<PaymentEventId> storePromise = paymentEventRepository.store(event);
                    return storePromise.thenApply(paymentEventId -> Either.right(event));
                }
        );
    }

    private Either<ProcessFailure, ProcessPaymentObject> validatePayment(ProcessPaymentObject paymentObject) {
        return Either.right(paymentObject);
    }

    private CompletionStage<Either<ProcessFailure, PaymentConfirmed>> processConfirm(
            PaymentRequested acceptPayment) {
        PaymentConfirmed event = PaymentConfirmed.eventOf(
                acceptPayment.getPaymentId(),
                acceptPayment.getCustomerId(),
                acceptPayment.getTimestamp()
        );
        CompletionStage<PaymentEventId> storePromise = paymentEventRepository.store(event);
        return storePromise.thenApply(paymentEventId -> Either.right(event));
    }

    private CompletionStage<Either<ProcessFailure, PaymentAuthorized>> processAuthorize(
            PaymentRequested acceptPayment) {
        ProcessAuthorizedObject authorizedPayment = ProcessAuthorizedObject.objectOf(
                acceptPayment.getPaymentId(),
                acceptPayment.getCustomerId(),
                acceptPayment.getPaymentMethod(),
                acceptPayment.getTransaction()
        );
        return validateAuthorized(authorizedPayment).fold(
                reject -> CompletableFuture.completedFuture(Either.left(reject)),
                accept -> {
                    PaymentAuthorized event = PaymentAuthorized.eventOf(
                            acceptPayment.getPaymentId(),
                            authorizedPayment.getCustomerId(),
                            authorizedPayment.getPaymentMethod(),
                            authorizedPayment.getTransaction(),
                            authorizedPayment.getTimestamp()
                    );
                    CompletionStage<PaymentEventId> storePromise = paymentEventRepository.store(event);
                    return storePromise.thenApply(paymentEventId -> Either.right(event));
                }
        );
    }

    private Either<ProcessFailure, ProcessAuthorizedObject> validateAuthorized(ProcessAuthorizedObject authorizedPayment) {
        return Either.right(authorizedPayment);
    }
}