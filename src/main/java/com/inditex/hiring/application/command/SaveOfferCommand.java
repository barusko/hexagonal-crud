package com.inditex.hiring.application.command;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class SaveOfferCommand {
    @NotNull
    private final Long offerId;
    @NotNull
    private final Long brandId;
    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH.mm.ssX")
    private final Timestamp startDate;
    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH.mm.ssX")
    private final Timestamp endDate;
    @NotNull
    private final Long priceListId;
    @NotNull
    private final String productPartNumber;
    @NotNull
    private final int priority;
    @NotNull
    private final BigDecimal price;
    @NotNull
    private final String currencyIso;

}
