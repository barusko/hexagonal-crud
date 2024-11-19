package com.inditex.hiring.application.ports.in.service;

import com.inditex.hiring.application.command.SaveOfferCommand;
import com.inditex.hiring.application.command.OfferManagementResponse;
import com.inditex.hiring.application.command.RemoveOfferCommand;
import com.inditex.hiring.application.exception.NoSuchResourceFoundException;
import com.inditex.hiring.application.mapper.OfferDataMapper;
import com.inditex.hiring.application.ports.out.repository.OfferRepository;
import com.inditex.hiring.application.queries.GetOfferByIdQuery;
import com.inditex.hiring.application.queries.GetOffersListQuery;
import com.inditex.hiring.application.queries.GetOffersQueryResponse;
import com.inditex.hiring.application.usecases.OfferManagementUseCase;
import com.inditex.hiring.domain.models.entity.Offer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;

@Slf4j
@Validated
@Service
public class OfferApplicationService implements OfferManagementUseCase {

    private final OfferRepository offerRepository;
    private final OfferDataMapper offerDataMapper;


    public OfferApplicationService(OfferRepository offerRepository, OfferDataMapper offerDataMapper) {
        this.offerRepository = offerRepository;
        this.offerDataMapper = offerDataMapper;
    }

    @Override
    public OfferManagementResponse saveOffer(SaveOfferCommand saveOfferCommand) {
        Offer offerResponse = offerRepository.save(offerDataMapper.createOfferCommandToOffer(saveOfferCommand));
        return offerDataMapper
                .offerToOfferManagementResponse(offerResponse, "Order Saved successfully");
    }

    @Override
    public OfferManagementResponse removeOffer(RemoveOfferCommand removeOfferCommand) {
        return null;
    }

    @Override
    public GetOffersQueryResponse getOffers(GetOffersListQuery getOffersListQuery) {
        return offerDataMapper.offerToOfferQueryResponse(offerRepository.getOffers(getOffersListQuery.getLimit()));
    }

    @Override
    public GetOffersQueryResponse getOffer(GetOfferByIdQuery getOfferByIdQuery) {
        return offerRepository.getOfferById(getOfferByIdQuery.getOfferId())
                .map(offer -> offerDataMapper.offerToOfferQueryResponse(Collections.singletonList(offer)))
                .orElseThrow(() -> new NoSuchResourceFoundException(
                        "Could not find order with tracking id: " + getOfferByIdQuery.getOfferId()
                ));
    }

}
