package com.example.handmade.model.dtos;

import com.example.handmade.model.enums.CategoryTypeEnum;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class AddOfferDTO {

    @NotNull
    private CategoryTypeEnum category;

    @NotNull(message = "{add.offer.description.length}")
    @Size(message = "{add.offer.description.length}",
            min = 5,
            max = 500)
    private String description;

    @NotNull
    @Positive
    private BigDecimal price;

    public AddOfferDTO() {
    }

    public AddOfferDTO(CategoryTypeEnum category, String description, BigDecimal price) {
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public CategoryTypeEnum getCategory() {
        return category;
    }

    public AddOfferDTO setCategory(CategoryTypeEnum category) {
        this.category = category;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddOfferDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddOfferDTO setDescription(String description) {
        this.description = description;
        return this;
    }
    public static AddOfferDTO empty(){
        return new AddOfferDTO(null,null,null);
    }

}
