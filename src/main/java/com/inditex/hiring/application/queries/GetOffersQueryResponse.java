package com.inditex.hiring.application.queries;

import com.inditex.hiring.application.command.SaveOfferCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class GetOffersQueryResponse {
    private final List<SaveOfferCommand> offers;
}
