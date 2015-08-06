package uk.co.themoderngeek.cookbook.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uk.co.themoderngeek.cookbook.controller.dto.IngredientDto;
import uk.co.themoderngeek.cookbook.controller.dto.RecipeDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RecipeDto getRecipe(@PathVariable long id) {
        return getRecipe();
    }

    //TODO this should be a repository
    private RecipeDto getRecipe() {
        List<IngredientDto> ingredients = new ArrayList<>();
        ingredients.add(new IngredientDto("mild olive oil", null, null));
        ingredients.add(new IngredientDto("Raw cooking chorizo", (double) 200, "g"));
        ingredients.add(new IngredientDto("Onion, finely chopped",(double) 1,null));
        ingredients.add(new IngredientDto("Spinach",(double) 260,"g"));
        ingredients.add(new IngredientDto("Skinless hake fillets",(double) 280,"g"));
        ingredients.add(new IngredientDto("sweet smoked paprika", 0.5,"tsp"));
        ingredients.add(new IngredientDto("Red chili", (double) 1, null));
        ingredients.add(new IngredientDto("cannellini beans, drained",(double) 400, "g"));
        ingredients.add(new IngredientDto("juiced",0.5, "lemon"));
        ingredients.add(new IngredientDto("extra virgin olive oil", (double) 1, "tbsp"));

        List<String> steps = new ArrayList<>();
        steps.add("Boil a full kettle of water and heat the grill to high. Heat 1 tsp oil in a large frying pan. Squeeze the meat from the chorizo directly into the pan. Add the onion and fry for 5 mins, crushing the meat with a spatula until broken up, golden and surrounded by its juices. The onion will also be soft and golden.");
        steps.add("Meanwhile, put the spinach in a colander, slowly pour over the boiled water to wilt it, then run under the cold tap. Squeeze out the excess water using your hands, then set aside. Line a baking tray with foil, rub with a little oil and place the fish on top. Season, sprinkle over the smoked paprika and drizzle with a little more oil.");
        steps.add("Tip the chilli into the pan with the sausages, fry for 1 min more, then add the beans, spinach, lemon juice and extra virgin olive oil. Let it warm through gently, then season to taste.");
        steps.add("Grill the fish for 5 mins or until flaky but not dry – you won’t need to turn it. Spoon the bean mixture onto plates, then carefully top with the fish and any juices from the tray. Serve with a dollop of Quick garlic mayonnaise (see recipe, right), if you like.");

        return new RecipeDto(ingredients, "Smoky hake, beans & greens", steps);
    }
}
