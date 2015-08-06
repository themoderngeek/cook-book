package uk.co.themoderngeek.cookbook.domain;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class IngredientTest {

    @Test
    public void testCreateValidIngredient() throws Exception {
        Ingredient ingredient = new Ingredient.Builder().withName("Onion, finely chopped").withAmount((double) 1).build();

        assertThat(ingredient.name(), is("Onion, finely chopped"));
        assertThat(ingredient.amount(), is((double) 1));
        assertThat(ingredient.unit(), nullValue());
    }

    @Test
    public void testCreateValidIngredientFull() throws Exception {
        Ingredient ingredient = new Ingredient.Builder().withName("sweet smoked paprika").withAmount(.5).withUnit("tsp").build();

        assertThat(ingredient.name(), is("sweet smoked paprika"));
        assertThat(ingredient.amount(), is(0.5));
        assertThat(ingredient.unit(), is("tsp"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateInvalidIngredient() throws Exception {
        new Ingredient.Builder().withAmount((double) 1).withUnit("tbsp").build();
    }
}