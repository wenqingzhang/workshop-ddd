package com.thoughtworks.dddworkshop.domain.event;

import com.thoughtworks.dddworkshop.domain.shared.Event;
import com.thoughtworks.dddworkshop.domain.vo.PaymentEventId;
import com.thoughtworks.dddworkshop.domain.vo.PaymentEventType;
import com.thoughtworks.dddworkshop.domain.vo.PaymentId;

import java.time.LocalDateTime;

public interface PaymentEvent extends Event {
    PaymentEventId getEventId();

    PaymentEventType getEventType();

    PaymentId getPaymentId();

    LocalDateTime getTimestamp();
}
