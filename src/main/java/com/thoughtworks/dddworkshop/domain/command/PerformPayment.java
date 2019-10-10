package com.thoughtworks.dddworkshop.domain.command;

import com.thoughtworks.dddworkshop.domain.vo.CustomerId;
import com.thoughtworks.dddworkshop.domain.vo.PaymentIntent;
import com.thoughtworks.dddworkshop.domain.vo.PaymentMethod;
import com.thoughtworks.dddworkshop.domain.vo.Transaction;
import lombok.Value;

import java.time.LocalDateTime;

@Value(staticConstructor = "commandOf")
public class PerformPayment implements PaymentCommand {
    private final CustomerId customerId;
    private final PaymentIntent paymentIntent;
    private final PaymentMethod paymentMethod;
    private final Transaction transaction;
    private final LocalDateTime timestamp = LocalDateTime.now();
}
