package uk.co.themoderngeek.cookbook.domain;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RecipeTest {

    private Ingredient eggs = new Ingredient.Builder().withAmount((double) 2).withName("Eggs").build();

    private String step = "Cook the eggs";

    @Test
    public void testCreateValidObject() throws Exception {
        Recipe recipe = new Recipe.Builder()
                .withIngredients(Collections.singletonList(eggs))
                .withSteps(Collections.singletonList(step))
                .withName("Omelet")
                .build();

        assertThat(recipe.name(), is("Omelet"));
        assertThat(recipe.ingredients(), is(Collections.singletonList(eggs)));
        assertThat(recipe.steps(), is(Collections.singletonList(step)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateInvalidObjectNoName() {
        new Recipe.Builder()
                .withIngredients(Collections.singletonList(eggs))
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateInvalidObjectNoIngredient() {
        new Recipe.Builder()
                .withName("Omelet")
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateInvalidObjectEmptyIngredient() {
        new Recipe.Builder()
                .withName("Omelet")
                .withIngredients(new ArrayList<>())
                .build();
    }
}