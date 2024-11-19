package com.inditex.hiring.infraestructure.adapters.persistence.offer.repository;

import com.inditex.hiring.infraestructure.adapters.persistence.offer.entity.OfferEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferJpaRepository extends JpaRepository<OfferEntity, Long> {

    Optional<OfferEntity> findByOfferId(Long offerId);

    @Query("SELECT o FROM OfferEntity o")
    List<OfferEntity> getOffers(Pageable pageable);

    OfferEntity removeBy(Long offerId);
}
