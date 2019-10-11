package com.thoughtworks.dddworkshop.domain.command;

import com.thoughtworks.dddworkshop.domain.vo.CustomerId;
import com.thoughtworks.dddworkshop.domain.vo.PaymentId;
import lombok.Value;

import java.time.LocalDateTime;

@Value(staticConstructor = "commandOf")
public class ConfirmPayment implements PaymentCommand {
    private final PaymentId paymentId;
    private final CustomerId customerId;
    private final LocalDateTime timestamp = LocalDateTime.now();
}
