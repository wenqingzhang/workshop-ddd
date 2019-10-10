package com.thoughtworks.dddworkshop.vo;

public enum PaymentIntent {
    AUTHORIZE, CAPTURE;

    public boolean isAuthorize() {
        return AUTHORIZE.equals(this);
    }

    public boolean isCapture() {
        return CAPTURE.equals(this);
    }
}