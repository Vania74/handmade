package com.example.handmade.model.entity;


import com.example.handmade.model.enums.CategoryTypeEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class OfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String img;

    public String getImg() {
        return img;
    }

    public OfferEntity setImg(String img) {
        this.img = img;
        return this;
    }

    @Enumerated(EnumType.STRING)
    private CategoryTypeEnum category;
    private BigDecimal price;

    public OfferEntity() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OfferEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryTypeEnum getCategory() {
        return category;
    }

    public OfferEntity setCategory(CategoryTypeEnum category) {
        this.category = category;
        return this;
    }
}
