package com.inditex.hiring.domain.models.entity;

import com.inditex.hiring.domain.models.common.AggregateRoot;
import com.inditex.hiring.domain.models.vo.*;

import java.sql.Timestamp;

public class Offer extends AggregateRoot<OfferId> {
    private final BrandId brandId;
    private final PriceListId priceListId;
    private final ProductPartNumber productPartNumber;
    private final int priority;
    private final Money money;
    private final Timestamp startDate;
    private final Timestamp endDate;

    private Offer(Builder builder) {
        super.setId(builder.offerId);
        brandId = builder.brandId;
        priceListId = builder.priceListId;
        productPartNumber = builder.productPartNumber;
        priority = builder.priority;
        money = builder.money;
        startDate = builder.startDate;
        endDate = builder.endDate;
    }


    public BrandId getBrandId() {
        return brandId;
    }

    public PriceListId getPriceListId() {
        return priceListId;
    }

    public ProductPartNumber getProductPartNumber() {
        return productPartNumber;
    }

    public int getPriority() {
        return priority;
    }

    public Money getMoney() {
        return money;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private OfferId offerId;
        private BrandId brandId;
        private PriceListId priceListId;
        private ProductPartNumber productPartNumber;
        private int priority;
        private Money money;
        private Timestamp startDate;
        private Timestamp endDate;

        private Builder() {
        }

        public Builder offerId(OfferId val) {
            offerId = val;
            return this;
        }

        public Builder brandId(BrandId val) {
            brandId = val;
            return this;
        }

        public Builder priceListId(PriceListId val) {
            priceListId = val;
            return this;
        }

        public Builder productPartNumber(ProductPartNumber val) {
            productPartNumber = val;
            return this;
        }

        public Builder priority(int val) {
            priority = val;
            return this;
        }

        public Builder money(Money val) {
            money = val;
            return this;
        }

        public Builder startDate(Timestamp val) {
            startDate = val;
            return this;
        }

        public Builder endDate(Timestamp val) {
            endDate = val;
            return this;
        }

        public Offer build() {
            return new Offer(this);
        }
    }
}
