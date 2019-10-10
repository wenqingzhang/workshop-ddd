package com.thoughtworks.dddworkshop.persistence.po;

import com.thoughtworks.dddworkshop.vo.PaymentEventId;
import com.thoughtworks.dddworkshop.vo.PaymentEventType;
import com.thoughtworks.dddworkshop.vo.PaymentId;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface PaymentEvent extends Serializable {
    PaymentEventId getEventId();

    PaymentEventType getEventType();

    PaymentId getPaymentId();

    LocalDateTime getTimestamp();
}
