package com.inditex.hiring.infraestructure.adapters.persistence.offer.mapper;

import com.inditex.hiring.domain.models.entity.Offer;
import com.inditex.hiring.domain.models.vo.*;
import com.inditex.hiring.infraestructure.adapters.persistence.offer.entity.OfferEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OfferMapper {

    public OfferEntity offertoOfferEntity(Offer offer) {

        Map<String, String> parNumberDetails = offer
                .getProductPartNumber()
                .splitProductPartNumber();

        return OfferEntity.builder()
                .offerId(offer.getId().getValue())
                .brandId(offer.getBrandId().getValue())
                .startDate(offer.getStartDate())
                .endDate(offer.getEndDate())
                .priceListId(offer.getPriceListId().getValue())
                .talla(parNumberDetails.get("talla"))
                .modelo(parNumberDetails.get("modelo"))
                .calidad(parNumberDetails.get("calidad"))
                .priority(offer.getPriority())
                .price(offer.getMoney().getPrice())
                .currencyIso(offer.getMoney().getCurrencyIso().getCurrencyIso3())
                .build();
    }

    public Offer offerEntityToOffer(OfferEntity offerEntity) {

        return Offer.builder()
                .offerId(new OfferId(offerEntity.getOfferId()))
                .brandId(new BrandId(offerEntity.getBrandId()))
                .startDate(offerEntity.getStartDate())
                .endDate(offerEntity.getEndDate())
                .priceListId(new PriceListId(offerEntity.getPriceListId()))
                .productPartNumber(new ProductPartNumber(String.join(offerEntity.getTalla(),offerEntity.getModelo(),offerEntity.getCalidad())))
                .priority(offerEntity.getPriority())
                .money(new Money(offerEntity.getPrice(), new CurrencyIso(offerEntity.getCurrencyIso())))
                .build();

    }
}
