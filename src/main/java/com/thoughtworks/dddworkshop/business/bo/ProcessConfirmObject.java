package com.thoughtworks.dddworkshop.business.bo;

import com.thoughtworks.dddworkshop.vo.CustomerId;
import com.thoughtworks.dddworkshop.vo.PaymentId;
import lombok.Value;

import java.time.LocalDateTime;

@Value(staticConstructor = "objectOf")
public class ProcessConfirmObject implements ProcessObject {
    private final PaymentId paymentId;
    private final CustomerId customerId;
    private final LocalDateTime timestamp = LocalDateTime.now();
}
