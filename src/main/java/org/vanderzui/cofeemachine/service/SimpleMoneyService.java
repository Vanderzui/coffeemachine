package org.vanderzui.cofeemachine.service;

import org.vanderzui.cofeemachine.entity.MoneyEntity;

import static org.vanderzui.cofeemachine.entity.MoneyEntity.BANK_INIT_MONEY_COUNT;
import static org.vanderzui.cofeemachine.entity.MoneyEntity.BANK_MIN_MONEY_COUNT;

public class SimpleMoneyService implements MoneyService {
    private final MoneyEntity moneyEntity = new MoneyEntity(BANK_INIT_MONEY_COUNT);

    @Override
    public int insertCredit(int money) {
        moneyEntity.setCredit(money);
        return moneyEntity.getCredit();
    }

    @Override
    public int returnCredit() {
        int credit = moneyEntity.getCredit();
        moneyEntity.setCredit(0);
        return credit;
    }

    @Override
    public int emptyBank() {
        int bank = moneyEntity.getBank() - BANK_MIN_MONEY_COUNT;
        moneyEntity.setBank(BANK_MIN_MONEY_COUNT);
        return bank;
    }

    @Override
    public void processRecipePrice(int price) {
        int credit = moneyEntity.getCredit();
        int result = credit - price;
        if (result < 0) {
            throw new RuntimeException("Enter more money, bitch!");
        }
        moneyEntity.setCredit(result);
    }
}
