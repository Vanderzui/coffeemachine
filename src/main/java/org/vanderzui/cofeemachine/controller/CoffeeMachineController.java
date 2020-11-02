package org.vanderzui.cofeemachine.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.vanderzui.cofeemachine.entity.RecipeEntity;
import org.vanderzui.cofeemachine.entity.RecipeType;
import org.vanderzui.cofeemachine.entity.SupplyEntity;
import org.vanderzui.cofeemachine.entity.SupplyType;
import org.vanderzui.cofeemachine.service.MoneyService;
import org.vanderzui.cofeemachine.service.RecipeService;
import org.vanderzui.cofeemachine.service.SupplyService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CoffeeMachineController {
    private final MoneyService moneyService;
    private final RecipeService recipeService;
    private final SupplyService supplyService;

    @PostMapping("/insertMoney")
    public int insertCredit(int money) {
        return moneyService.insertCredit(money);
    }

    @GetMapping("/returnMoney")
    public int returnCredit() {
        return moneyService.returnCredit();
    }

    @PutMapping("/emptyBank")
    public int emptyBank() {
        return moneyService.emptyBank();
    }

    @GetMapping("/kofi")
    public RecipeEntity chooseRecipe(RecipeType recipeType) {
        return recipeService.chooseRecipe(recipeType);
    }

    @PutMapping("/fill")
    public List<SupplyEntity> fillSupply(@RequestBody Map<SupplyType, Integer> supplies) {
        return supplyService.fillSupply(supplies);
    }
}
