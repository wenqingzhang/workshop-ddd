package com.thoughtworks.dddworkshop.business.bo;

import com.thoughtworks.dddworkshop.vo.CustomerId;
import com.thoughtworks.dddworkshop.vo.PaymentIntent;
import com.thoughtworks.dddworkshop.vo.PaymentMethod;
import com.thoughtworks.dddworkshop.vo.Transaction;
import lombok.Value;

import java.time.LocalDateTime;

@Value(staticConstructor = "objectOf")
public class ProcessPaymentObject implements ProcessObject {
    private final CustomerId customerId;
    private final PaymentIntent paymentIntent;
    private final PaymentMethod paymentMethod;
    private final Transaction transaction;
    private final LocalDateTime timestamp = LocalDateTime.now();
}
