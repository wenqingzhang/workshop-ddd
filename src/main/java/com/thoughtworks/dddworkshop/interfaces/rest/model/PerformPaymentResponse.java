package com.thoughtworks.dddworkshop.interfaces.rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class PerformPaymentResponse {
    private String paymentId;
    private String status;
}
