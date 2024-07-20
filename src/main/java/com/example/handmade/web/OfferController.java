package com.example.handmade.web;

import com.example.handmade.model.dtos.AddOfferDTO;
import com.example.handmade.model.enums.CategoryTypeEnum;
import com.example.handmade.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }
    @ModelAttribute("allCategoryType")
    public CategoryTypeEnum[] allCategoryTypes(){
        return CategoryTypeEnum.values();
    }

    @GetMapping("/offers/add")
    public String newOffer(Model model) {
        if ((!model.containsAttribute("addOfferDTO"))){
            model.addAttribute("addOfferDTO" , AddOfferDTO.empty());
        }

       // model.addAttribute("allCategoryTypes", CategoryTypeEnum.values());

        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String createOffer(@Valid  AddOfferDTO addOfferDTO,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addOfferDTO", addOfferDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDTO", bindingResult);
            return "redirect:/offers/add";
        }
        long newOfferId = offerService.createOffer(addOfferDTO);
        return "redirect:/offers/"+newOfferId;

    }
}
