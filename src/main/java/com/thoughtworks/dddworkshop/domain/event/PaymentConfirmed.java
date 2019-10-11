package com.thoughtworks.dddworkshop.domain.event;

import com.thoughtworks.dddworkshop.domain.vo.CustomerId;
import com.thoughtworks.dddworkshop.domain.vo.PaymentEventId;
import com.thoughtworks.dddworkshop.domain.vo.PaymentEventType;
import com.thoughtworks.dddworkshop.domain.vo.PaymentId;
import lombok.Value;

import java.time.LocalDateTime;

@Value(staticConstructor = "eventOf")
public class PaymentConfirmed implements PaymentEvent {
    private final PaymentEventId eventId = new PaymentEventId();
    private final PaymentId paymentId;
    private final CustomerId customerId;
    private final LocalDateTime timestamp;

    @Override
    public PaymentEventType getEventType() {
        return PaymentEventType.PAYMENT_CONFIRMED;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
