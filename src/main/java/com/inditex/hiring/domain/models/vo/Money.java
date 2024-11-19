package com.inditex.hiring.domain.models.vo;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private final BigDecimal price;
    private final CurrencyIso currencyIso;

    public Money(BigDecimal price, CurrencyIso currencyIso) {
        this.price = price;
        this.currencyIso = currencyIso;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CurrencyIso getCurrencyIso() {
        return currencyIso;
    }

    public boolean isGreaterThanZero() {
        return this.price != null &&  this.price.compareTo(BigDecimal.ZERO) > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(price, money.price) && Objects.equals(currencyIso, money.currencyIso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, currencyIso);
    }
}
