package com.example.handmade.service.impl;

import com.example.handmade.model.dtos.AddOfferDTO;
import com.example.handmade.model.dtos.OfferDetailDTO;
import com.example.handmade.model.dtos.OfferSummaryDTO;
import com.example.handmade.model.entity.OfferEntity;
import com.example.handmade.repository.OfferRepository;
import com.example.handmade.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public void deleteOffer(long offerId) {
        offerRepository.deleteById(offerId);
    }

    @Override
    public OfferDetailDTO getOfferDetail(Long id) {
        return this.offerRepository.findById(id).map(OfferServiceImpl::toOfferDetail).orElseThrow();

    }

    @Override
    public List<OfferSummaryDTO> getAllOffers() {
        return offerRepository.findAll().stream().map(OfferServiceImpl::toOfferSummary).collect(Collectors.toList());
    }
    private static OfferSummaryDTO toOfferSummary(OfferEntity offer){
        OfferSummaryDTO dto = new OfferSummaryDTO(offer.getId(),offer.getImg(),offer.getPrice());
        return dto;
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
