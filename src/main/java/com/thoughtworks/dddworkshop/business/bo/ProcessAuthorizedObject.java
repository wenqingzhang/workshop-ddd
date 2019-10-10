package com.thoughtworks.dddworkshop.business.bo;

import com.thoughtworks.dddworkshop.vo.CustomerId;
import com.thoughtworks.dddworkshop.vo.PaymentId;
import com.thoughtworks.dddworkshop.vo.PaymentMethod;
import com.thoughtworks.dddworkshop.vo.Transaction;
import lombok.Value;

import java.time.LocalDateTime;

@Value(staticConstructor = "objectOf")
public class ProcessAuthorizedObject implements ProcessObject {
    private final PaymentId paymentId;
    private final CustomerId customerId;
    private final PaymentMethod paymentMethod;
    private final Transaction transaction;
    private final LocalDateTime timestamp = LocalDateTime.now();
}
