package com.inditex.hiring.infraestructure.adapters.rest;

import com.inditex.hiring.application.command.SaveOfferCommand;
import com.inditex.hiring.application.command.OfferManagementResponse;
import com.inditex.hiring.application.queries.GetOfferByIdQuery;
import com.inditex.hiring.application.queries.GetOffersListQuery;
import com.inditex.hiring.application.queries.GetOffersQueryResponse;
import com.inditex.hiring.application.usecases.OfferManagementUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/offers", produces = "application/vnd.api.v1+json")
public class OfferController {

    private final OfferManagementUseCase offerManagementUseCase;

    public OfferController(OfferManagementUseCase offerManagementUseCase) {
        this.offerManagementUseCase = offerManagementUseCase;
    }


    @GetMapping("/{offerId}")
    public ResponseEntity<GetOffersQueryResponse> getOffer(@PathVariable final Long offerId) {
        GetOffersQueryResponse offerList = offerManagementUseCase
                .getOffer(GetOfferByIdQuery.builder()
                        .offerId(offerId)
                        .build());
        return ResponseEntity.ok(offerList);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<OfferManagementResponse> saveOffer(@RequestBody final SaveOfferCommand saveOfferCommand) {
        log.info("Saving Offer with Id: {}", saveOfferCommand.getOfferId());
        OfferManagementResponse response = offerManagementUseCase.saveOffer(saveOfferCommand);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<GetOffersQueryResponse> getOffers(@RequestParam(value="limit", defaultValue="10") String limit) {

        GetOffersQueryResponse getOffersQueryResponse = offerManagementUseCase.getOffers(
                GetOffersListQuery.builder()
                        .limit(Integer.parseInt(limit))
                        .build()
        );

        return ResponseEntity.ok(getOffersQueryResponse);
    }
}
