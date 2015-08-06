package uk.co.themoderngeek.cookbook.domain;

import java.util.Collections;
import java.util.List;


public class Recipe {

    private List<Ingredient> ingredients;

    private List<String> steps;

    private String name;

    private Recipe() {

    }

    public Recipe(Builder builder) {
        this.ingredients = builder.ingredients;
        this.name = builder.name;
        this.steps = builder.steps;
    }

    public List<String> steps() {
        return Collections.unmodifiableList(steps);
    }

    public List<Ingredient> ingredients() {
        return Collections.unmodifiableList(ingredients);
    }

    public String name() {
        return name;
    }

    public static class Builder {

        private List<Ingredient> ingredients;

        private String name;

        private List<String> steps;

        public Builder withSteps(List<String> steps) {
            this.steps = steps;
            return this;
        }

        public Builder withIngredients(List<Ingredient> ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Recipe build() {
            validate();
            return new Recipe(this);
        }

        public void validate() {
            if(name == null || name.trim().equals("")) {
                throw new IllegalArgumentException("The recipe requires a name");
            }

            if(ingredients == null || ingredients.size() == 0) {
                throw new IllegalArgumentException("The recipe requires at least one ingredient");
            }
        }
    }
}

