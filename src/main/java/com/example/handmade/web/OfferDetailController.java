package com.example.handmade.web;


import com.example.handmade.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OfferDetailController {
    private final OfferService offerService;

    public OfferDetailController(OfferService offerService) {
        this.offerService = offerService;
    }
    @GetMapping("/offers/{id}")
    public String offerDetail(@PathVariable("id") Long id, Model model){
        model.addAttribute("offerDetail",offerService.getOfferDetail(id));
        return "details";
    }
}
