package com.thoughtworks.dddworkshop.domain.entity;


import com.thoughtworks.dddworkshop.domain.event.PaymentEvent;
import com.thoughtworks.dddworkshop.domain.vo.PaymentEventId;

import java.util.concurrent.CompletionStage;

public interface PaymentEventRepository {
    CompletionStage<PaymentEventId> store(PaymentEvent paymentEvent);
}
