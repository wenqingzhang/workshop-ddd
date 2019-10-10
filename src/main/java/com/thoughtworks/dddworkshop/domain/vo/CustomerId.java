package com.thoughtworks.dddworkshop.domain.vo;

import com.thoughtworks.dddworkshop.domain.shared.RandomUUID;

public class CustomerId extends RandomUUID {

    public CustomerId(String id) {
        super(id);
    }

    @Override
    protected String getPrefix() {
        return "CST-%s";
    }
}
