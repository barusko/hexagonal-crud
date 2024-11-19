package com.inditex.hiring.application.queries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class GetOffersListQuery {
    @NotNull
    private final int limit;
}
