package org.vanderzui.cofeemachine.entity;

import java.util.ArrayList;
import java.util.List;

public class RecipeEntity {

    private RecipeType recipeType;
    private int price;
    private List<SupplyEntity> supplyEntities = new ArrayList<>();

    public RecipeEntity() {
    }

    public RecipeEntity(RecipeType recipeType) {
        this.recipeType = recipeType;
    }

    public RecipeType getRecipeType() {
        return recipeType;
    }

    public void setRecipeType(RecipeType recipeType) {
        this.recipeType = recipeType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<SupplyEntity> getSupplyEntities() {
        return supplyEntities;
    }

    public void setSupplyEntities(List<SupplyEntity> supplyEntities) {
        this.supplyEntities = supplyEntities;
    }
}
