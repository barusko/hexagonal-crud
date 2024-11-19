package com.inditex.hiring.application.queries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class GetOfferByIdQuery {

    @NotNull
    private final Long offerId;
}
