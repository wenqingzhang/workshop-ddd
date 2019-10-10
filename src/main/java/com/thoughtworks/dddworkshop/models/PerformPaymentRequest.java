package com.thoughtworks.dddworkshop.models;

import com.thoughtworks.dddworkshop.utils.validation.ValidEnum;
import com.thoughtworks.dddworkshop.vo.PaymentMethod;
import com.thoughtworks.dddworkshop.vo.PaymentIntent;
import com.thoughtworks.dddworkshop.vo.Transaction;

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