package org.vanderzui.cofeemachine.service;

import org.vanderzui.cofeemachine.entity.RecipeEntity;
import org.vanderzui.cofeemachine.entity.RecipeType;

public class SimpleRecipeService implements RecipeService {
    MoneyService moneyService = new SimpleMoneyService();

    @Override
    public RecipeEntity chooseRecipe(RecipeType recipeType) {
        RecipeEntity recipeEntity = getRecipeEntityByType(recipeType);
        moneyService.processRecipePrice(recipeEntity.getPrice());
//        supplyService.processRecipeSupplies(recipeEntity.getSupplyEntities());
        return recipeEntity;
    }

    private RecipeEntity getRecipeEntityByType(RecipeType recipeType){
        return new RecipeEntity(recipeType);
    }
}
