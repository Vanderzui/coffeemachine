package org.vanderzui.cofeemachine.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class RecipeEntity {

    private RecipeType recipeType;
    private int price;
    private Map<SupplyType, Integer> requiredSupplies;
}
