package com.example.handmade.service;

import com.example.handmade.model.dtos.AddOfferDTO;
import com.example.handmade.model.dtos.OfferDetailDTO;

public interface OfferService {
    Long createOffer(AddOfferDTO addOfferDTO);

    public OfferDetailDTO getOfferDetail(Long id);

}
