package com.example.handmade.service.impl;

import com.example.handmade.model.dtos.AddOfferDTO;
import com.example.handmade.model.dtos.OfferDetailDTO;
import com.example.handmade.model.entity.OfferEntity;
import com.example.handmade.repository.OfferRepository;
import com.example.handmade.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public Long createOffer(AddOfferDTO addOfferDTO) {
        OfferEntity offer = map(addOfferDTO);
         return    offerRepository.save(map(addOfferDTO)).getId();

    }

    @Override
    public OfferDetailDTO getOfferDetail(Long id) {
        return this.offerRepository.findById(id).map(OfferServiceImpl::toOfferDetail).orElseThrow();

    }
    private static OfferDetailDTO toOfferDetail(OfferEntity offer){
        return new OfferDetailDTO(offer.getId(),offer.getDescription(),offer.getCategory(),offer.getPrice());
    }

    private static OfferEntity map(AddOfferDTO addOfferDTO){
        return new OfferEntity()
                .setDescription(addOfferDTO.getDescription())
                .setCategory(addOfferDTO.getCategory())
                .setPrice(addOfferDTO.getPrice());
    }
}
