package org.vanderzui.cofeemachine.service;

import org.vanderzui.cofeemachine.entity.RecipeEntity;
import org.vanderzui.cofeemachine.entity.RecipeType;

public interface RecipeService {
    RecipeEntity chooseRecipe(RecipeType recipeType);
}
