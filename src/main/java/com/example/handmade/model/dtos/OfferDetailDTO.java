package com.example.handmade.model.dtos;

import com.example.handmade.model.enums.CategoryTypeEnum;

import java.math.BigDecimal;

public class OfferDetailDTO {
    private Long id;
    private String description;
    private CategoryTypeEnum category;
    private BigDecimal price;

    public OfferDetailDTO(Long id, String description, CategoryTypeEnum category, BigDecimal price) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public OfferDetailDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferDetailDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryTypeEnum getCategory() {
        return category;
    }

    public OfferDetailDTO setCategory(CategoryTypeEnum category) {
        this.category = category;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferDetailDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
