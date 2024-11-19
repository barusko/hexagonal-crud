package com.inditex.hiring.application.mapper;

import com.inditex.hiring.application.command.SaveOfferCommand;
import com.inditex.hiring.application.command.OfferManagementResponse;
import com.inditex.hiring.application.queries.GetOffersQueryResponse;
import com.inditex.hiring.domain.models.entity.Offer;
import com.inditex.hiring.domain.models.vo.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OfferDataMapper {

    public Offer createOfferCommandToOffer(SaveOfferCommand saveOfferCommand) {
        return Offer.builder()
                .offerId(new OfferId(saveOfferCommand.getOfferId()))
                .brandId(new BrandId(saveOfferCommand.getBrandId()))
                .startDate(saveOfferCommand.getStartDate())
                .endDate(saveOfferCommand.getEndDate())
                .priceListId(new PriceListId(saveOfferCommand.getPriceListId()))
                .productPartNumber(new ProductPartNumber(saveOfferCommand.getProductPartNumber()))
                .priority(saveOfferCommand.getPriority())
                .money(new Money(saveOfferCommand.getPrice(), new CurrencyIso(saveOfferCommand.getCurrencyIso())))
                .build();
    }

    public OfferManagementResponse offerToOfferManagementResponse(Offer offer, String message) {
        List<String> messages = new ArrayList<>();
        messages.add(message);
        return OfferManagementResponse.builder()
                .offerId(offer.getId().getValue())
                .OfferStatus(OfferStatus.ACTIVE)
                .messages(messages)
                .performedAt(LocalDateTime.now())
                .build();
    }

    public GetOffersQueryResponse offerToOfferQueryResponse(List<Offer> offerList) {
        List<SaveOfferCommand> saveOfferCommands = offerList.stream()
                .map(offer -> SaveOfferCommand.builder()
                        .offerId(offer.getId().getValue())
                        .brandId(offer.getBrandId().getValue())
                        .startDate(offer.getStartDate())
                        .endDate(offer.getEndDate())
                        .priceListId(offer.getPriceListId().getValue())
                        .productPartNumber(offer.getProductPartNumber().getPartNumber())
                        .priority(offer.getPriority())
                        .price(offer.getMoney().getPrice())
                        .currencyIso(offer.getMoney().getCurrencyIso().getCurrencyIso3())
                        .build())
                .collect(Collectors.toList());

        return GetOffersQueryResponse.builder()
                .offers(saveOfferCommands)
                .build();
    }

}
