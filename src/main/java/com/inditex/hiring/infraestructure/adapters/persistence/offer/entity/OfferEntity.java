package com.inditex.hiring.infraestructure.adapters.persistence.offer.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "offers")
public class OfferEntity {

    @Id
    @Column(name = "OFFER_ID")
    private Long offerId;

    @Column(name = "BRAND_ID")
    private Long brandId;

    @Column(name = "START_DATE")
    private Timestamp startDate;

    @Column(name = "END_DATE")
    private Timestamp endDate;

    @Column(name = "PRICE_LIST")
    private Long priceListId;

    @Column(name = "TALLA")
    private String talla;

    @Column(name = "MODELO")
    private String modelo;

    @Column(name = "CALIDAD")
    private String calidad;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "CURR")
    private String currencyIso;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferEntity that = (OfferEntity) o;
        return Objects.equals(offerId, that.offerId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(offerId);
    }
}
