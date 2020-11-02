package org.vanderzui.cofeemachine.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.vanderzui.cofeemachine.entity.RecipeEntity;
import org.vanderzui.cofeemachine.entity.RecipeType;
import org.vanderzui.cofeemachine.entity.SupplyType;
import org.vanderzui.cofeemachine.exception.CoffeeMachineException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.vanderzui.cofeemachine.entity.RecipeType.AMERICANO;
import static org.vanderzui.cofeemachine.entity.RecipeType.CAPPUCCINO;
import static org.vanderzui.cofeemachine.entity.RecipeType.ESPRESSO;
import static org.vanderzui.cofeemachine.entity.RecipeType.HOT_WATER;
import static org.vanderzui.cofeemachine.entity.RecipeType.LATTE;
import static org.vanderzui.cofeemachine.entity.RecipeType.MILK_RECIPE;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleRecipeService implements RecipeService {
    private final MoneyService moneyService;
    private final SupplyService supplyService;

    private static List<RecipeEntity> recipes = new ArrayList<>();

    @PostConstruct
    private void postConstruct(){
        Map<SupplyType, Integer> americanoSupplies = new HashMap<>();
        americanoSupplies.put(SupplyType.COFFEE, 2);
        RecipeEntity americano = RecipeEntity.builder()
                .recipeType(AMERICANO)
                .price(20)
                .requiredSupplies(americanoSupplies)
                .build();
        recipes.add(americano);
    }

    @Override
    public RecipeEntity chooseRecipe(RecipeType recipeType) {
        RecipeEntity recipeEntity = getRecipeEntityByType(recipeType)
                .orElseThrow(() -> new CoffeeMachineException("Recipe not found, bitch!"));
        moneyService.processRecipePrice(recipeEntity.getPrice());
        supplyService.processRecipeSupplies(recipeEntity.getRequiredSupplies());
        return recipeEntity;
    }

    private Optional<RecipeEntity> getRecipeEntityByType(RecipeType recipeType){
        return recipes
                .stream()
                .filter(recipeEntity -> recipeEntity.getRecipeType().equals(recipeType))
                .findFirst();
    }
}
