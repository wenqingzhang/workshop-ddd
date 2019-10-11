package com.thoughtworks.dddworkshop.interfaces.rest.model;

import com.thoughtworks.dddworkshop.domain.vo.PaymentIntent;
import com.thoughtworks.dddworkshop.domain.vo.PaymentMethod;
import com.thoughtworks.dddworkshop.domain.vo.Transaction;
import com.thoughtworks.dddworkshop.infrastructure.util.validation.ValidEnum;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class PerformPaymentRequest {
    @NotNull
    private String customerId;
    @ValidEnum(conformsTo = PaymentIntent.class)
    private String paymentIntent;
    @ValidEnum(conformsTo = PaymentMethod.class)
    private String paymentMethod;
    @Valid
    private Transaction transaction;
}
