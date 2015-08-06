package uk.co.themoderngeek.cookbook.domain;

public class Ingredient {

    private String name;

    private Double amount;

    private String unit;

    private Ingredient() {

    }

    public Ingredient(Builder builder) {
        this.name = builder.name;
        this.amount = builder.amount;
        this.unit = builder.unit;
    }

    public String name() {
        return name;
    }

    public Double amount() {
        return amount;
    }

    public String unit() {
        return unit;
    }

    public static class Builder {

        private String name;

        private Double amount;

        private String unit;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public Builder withUnit(String unit) {
            this.unit = unit;
            return this;
        }

        public Ingredient build() {
            validate();
            return new Ingredient(this);
        }

        public void validate() {
            if(this.name == null || this.name.trim().equals("")) {
                throw new IllegalArgumentException("Name cannot be null or empty");
            }
        }
    }
}

