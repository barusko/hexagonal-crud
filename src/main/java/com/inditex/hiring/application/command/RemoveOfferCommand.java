package com.inditex.hiring.application.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class RemoveOfferCommand {

    @NotNull
    private final Long offerId;
}
