package com.inditex.hiring.application.command;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inditex.hiring.domain.models.vo.OfferStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class OfferManagementResponse {
    @NotNull
    private final Long offerId;
    @NotNull
    private final OfferStatus OfferStatus;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private final LocalDateTime performedAt;

    private final List<String> messages;
}
