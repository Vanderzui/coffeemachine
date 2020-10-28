package org.vanderzui.cofeemachine.controller;

import org.vanderzui.cofeemachine.entity.RecipeEntity;
import org.vanderzui.cofeemachine.entity.RecipeType;
import org.vanderzui.cofeemachine.entity.SupplyEntity;
import org.vanderzui.cofeemachine.service.MoneyService;
import org.vanderzui.cofeemachine.service.SimpleMoneyService;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachineController {
    private static final MoneyService moneyService = new SimpleMoneyService();

    public int insertCredit(int money){
        return moneyService.insertCredit(money);
    }

    public int returnCredit() {
        return moneyService.returnCredit();
    }

    public int emptyBank(){
        return moneyService.emptyBank();
    }

    public RecipeEntity chooseRecipe(RecipeType recipeType){
        return new RecipeEntity();
    }

    public List<SupplyEntity> fillSupply(List<SupplyEntity> supplyEntities){
        return new ArrayList<>();
    }
}
