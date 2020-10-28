package org.vanderzui.cofeemachine.service;

public interface MoneyService {
    int insertCredit(int money);

    int returnCredit();

    int emptyBank();

    void processRecipePrice(int price);
}
