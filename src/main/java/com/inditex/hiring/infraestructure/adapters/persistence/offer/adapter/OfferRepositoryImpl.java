package com.inditex.hiring.infraestructure.adapters.persistence.offer.adapter;


import com.inditex.hiring.application.ports.out.repository.OfferRepository;
import com.inditex.hiring.domain.models.entity.Offer;
import com.inditex.hiring.infraestructure.adapters.persistence.offer.mapper.OfferMapper;
import com.inditex.hiring.infraestructure.adapters.persistence.offer.repository.OfferJpaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OfferRepositoryImpl implements OfferRepository {

    private final OfferJpaRepository offerJpaRepository;

    private final OfferMapper offerMapper;

    public OfferRepositoryImpl(OfferJpaRepository offerJpaRepository, OfferMapper offerMapper) {
        this.offerJpaRepository = offerJpaRepository;
        this.offerMapper = offerMapper;
    }


    @Override
    public List<Offer> getOffers(int limit) {

        return offerJpaRepository.getOffers(new PageRequest(0, limit))
                .stream()
                .map(offerMapper::offerEntityToOffer)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Offer> getOfferById(Long offerId) {
        return offerJpaRepository.findByOfferId(offerId)
                .map(offerMapper::offerEntityToOffer);
    }

    @Override
    public Offer save(Offer offer) {
        return offerMapper.offerEntityToOffer(offerJpaRepository
                        .save(offerMapper.offertoOfferEntity(offer)));
    }

    @Override
    public Offer removeOfferById(Long offerId) {
        return offerMapper
                .offerEntityToOffer(offerJpaRepository.removeBy(offerId));
    }
}
