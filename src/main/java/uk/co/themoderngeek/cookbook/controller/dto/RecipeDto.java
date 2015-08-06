package uk.co.themoderngeek.cookbook.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RecipeDto {
    @JsonProperty
    private List<IngredientDto> ingredients;

    @JsonProperty
    private String name;

    @JsonProperty
    private List<String> steps;

    public RecipeDto(List<IngredientDto> ingredients, String name, List<String> steps) {
        this.ingredients = ingredients;
        this.name = name;
        this.steps = steps;
    }
}
