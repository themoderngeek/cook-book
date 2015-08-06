package uk.co.themoderngeek.cookbook.controller.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class IngredientDto {

    @JsonProperty
    private String name;

    @JsonProperty
    private Double amount;

    @JsonProperty
    private String unit;

    public IngredientDto(String name, Double amount, String unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }
}
