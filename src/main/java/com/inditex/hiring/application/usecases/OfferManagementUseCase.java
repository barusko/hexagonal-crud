package com.inditex.hiring.application.usecases;

import com.inditex.hiring.application.command.SaveOfferCommand;
import com.inditex.hiring.application.command.OfferManagementResponse;
import com.inditex.hiring.application.command.RemoveOfferCommand;
import com.inditex.hiring.application.queries.GetOfferByIdQuery;
import com.inditex.hiring.application.queries.GetOffersListQuery;
import com.inditex.hiring.application.queries.GetOffersQueryResponse;

import javax.validation.Valid;

public interface OfferManagementUseCase {
    OfferManagementResponse saveOffer(@Valid SaveOfferCommand saveOfferCommand);

    OfferManagementResponse removeOffer(@Valid RemoveOfferCommand removeOfferCommand);

    GetOffersQueryResponse getOffers(@Valid  GetOffersListQuery getOffersListQuery);

    GetOffersQueryResponse getOffer(@Valid GetOfferByIdQuery getOfferByIdQuery);
}
