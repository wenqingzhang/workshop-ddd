package com.thoughtworks.dddworkshop.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.dddworkshop.utils.validation.ValidEnum;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Currency;

@EqualsAndHashCode(exclude = {"amountAsBigDecimal"})
public class Money {
    @ValidEnum(conformsTo = CurrencyCodes.class)
    public final String currency;
    @NotNull
    public final Integer amount;
    @NotNull
    public final Integer scale;
    @JsonIgnore
    public final BigDecimal amountAsBigDecimal;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Money(@JsonProperty("currency") String currency,
                 @JsonProperty("amount") Integer amount,
                 @JsonProperty("scale") Integer scale) {
        this.currency = Currency.getInstance(currency).getCurrencyCode();
        this.amount = amount;
        this.scale = scale;
        this.amountAsBigDecimal = new BigDecimal(amount).movePointLeft(2).setScale(scale);
    }
}