package com.thoughtworks.dddworkshop.domain.entity;

import com.thoughtworks.dddworkshop.domain.command.AuthorizePayment;
import com.thoughtworks.dddworkshop.domain.command.ConfirmPayment;
import com.thoughtworks.dddworkshop.domain.command.PerformPayment;
import com.thoughtworks.dddworkshop.domain.command.handler.AuthorizePaymentHandler;
import com.thoughtworks.dddworkshop.domain.command.handler.ConfirmPaymentHandler;
import com.thoughtworks.dddworkshop.domain.command.handler.PerformPaymentHandler;
import com.thoughtworks.dddworkshop.domain.shared.AggregateRoot;
import com.thoughtworks.dddworkshop.domain.vo.PaymentId;
import org.springframework.context.ApplicationContext;

public class Payment extends AggregateRoot<Payment, PaymentId> {

    public Payment(ApplicationContext applicationContext) {
        super(applicationContext, new PaymentId());
    }

    public Payment(ApplicationContext applicationContext, PaymentId paymentId) {
        super(applicationContext, paymentId);
    }

    @Override
    public boolean sameIdentityAs(Payment other) {
        return other != null && entityId.sameValueAs(other.entityId);
    }

    @Override
    public PaymentId id() {
        return entityId;
    }

    @Override
    protected AggregateRootBehavior initialBehavior() {
        AggregateRootBehaviorBuilder behaviorBuilder = new AggregateRootBehaviorBuilder();

        //TODO: implement here

        return behaviorBuilder.build();
    }
}
