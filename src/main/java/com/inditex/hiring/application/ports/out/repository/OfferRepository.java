package com.inditex.hiring.application.ports.out.repository;

import com.inditex.hiring.domain.models.entity.Offer;

import java.util.List;
import java.util.Optional;

public interface OfferRepository {

    Offer save(Offer offer);
    Offer removeOfferById(Long offerId);
    Optional<Offer> getOfferById(Long offerId);
    List<Offer> getOffers(int limit);

}
