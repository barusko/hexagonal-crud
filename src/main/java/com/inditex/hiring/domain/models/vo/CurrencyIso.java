package com.inditex.hiring.domain.models.vo;

import java.util.Objects;

public class CurrencyIso {

    private final String currencyISO3;

    public CurrencyIso(String currencyISO3) {
        this.currencyISO3 = currencyISO3;
    }

    public String getCurrencyIso3() {
        return currencyISO3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyIso that = (CurrencyIso) o;
        return Objects.equals(currencyISO3, that.currencyISO3);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(currencyISO3);
    }
}
