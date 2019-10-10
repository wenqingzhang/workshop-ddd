package com.thoughtworks.dddworkshop.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

public abstract class RandomUUID {
    @NotNull
    @Size(min = 16, max = 50)
    public final String id;


    public RandomUUID() {
        this.id = String.format(getPrefix(), UUID.randomUUID().toString());
    }

    public RandomUUID(String id) {
        this.id = id;
    }

    protected abstract String getPrefix();
}
