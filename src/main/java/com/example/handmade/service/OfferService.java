package com.example.handmade.service;

import com.example.handmade.model.dtos.AddOfferDTO;
import com.example.handmade.model.dtos.OfferDetailDTO;
import com.example.handmade.model.dtos.OfferSummaryDTO;

import java.util.List;

public interface OfferService {
    Long createOffer(AddOfferDTO addOfferDTO);
    void deleteOffer(long offerId);

   OfferDetailDTO getOfferDetail(Long id);


    List<OfferSummaryDTO> getAllOffers();

}
