package com.thoughtworks.dddworkshop.domain.event;

import com.thoughtworks.dddworkshop.domain.vo.*;
import lombok.Value;

import java.time.LocalDateTime;

@Value(staticConstructor = "eventOf")
public class PaymentRequested implements PaymentEvent {
    private final PaymentEventId eventId = new PaymentEventId();
    private final PaymentId paymentId;
    private final CustomerId customerId;
    private final PaymentIntent paymentIntent;
    private final PaymentMethod paymentMethod;
    private final Transaction transaction;
    private final LocalDateTime timestamp;

    @Override
    public PaymentEventType getEventType() {
        return PaymentEventType.PAYMENT_REQUESTED;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
