package com.thoughtworks.dddworkshop.domain.command;

import com.thoughtworks.dddworkshop.domain.vo.CustomerId;
import com.thoughtworks.dddworkshop.domain.vo.PaymentId;
import com.thoughtworks.dddworkshop.domain.vo.PaymentMethod;
import com.thoughtworks.dddworkshop.domain.vo.Transaction;
import lombok.Value;

import java.time.LocalDateTime;

@Value(staticConstructor = "commandOf")
public class AuthorizePayment implements PaymentCommand {
    private final PaymentId paymentId;
    private final CustomerId customerId;
    private final PaymentMethod paymentMethod;
    private final Transaction transaction;
    private final LocalDateTime timestamp = LocalDateTime.now();
}
