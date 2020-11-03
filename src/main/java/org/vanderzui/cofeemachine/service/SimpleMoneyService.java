package org.vanderzui.cofeemachine.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.vanderzui.cofeemachine.entity.BankEntity;
import org.vanderzui.cofeemachine.exception.CoffeeMachineException;

import javax.annotation.PostConstruct;

import static org.vanderzui.cofeemachine.entity.BankEntity.BANK_INIT_MONEY_COUNT;
import static org.vanderzui.cofeemachine.entity.BankEntity.BANK_MIN_MONEY_COUNT;

@Slf4j
@Service
public class SimpleMoneyService implements MoneyService {
    private static final BankEntity bankEntity = new BankEntity();

    @PostConstruct
    private void postConstruct(){
        bankEntity.setBank(BANK_INIT_MONEY_COUNT);
    }

    @Override
    public int insertCredit(int money) {
        bankEntity.setCredit(money);
        log.info("Credit is {}", bankEntity.getCredit());
        return bankEntity.getCredit();
    }

    @Override
    public int returnCredit() {
        int credit = bankEntity.getCredit();
        bankEntity.setCredit(0);
        log.info("Credit is {}", bankEntity.getCredit());
        return credit;
    }

    @Override
    public int emptyBank() {
        int bank = bankEntity.getBank() - BANK_MIN_MONEY_COUNT;
        bankEntity.setBank(BANK_MIN_MONEY_COUNT);
        log.info("Bank is {}", bankEntity.getBank());
        return bank;
    }

    @Override
    public void processRecipePrice(int price) {
        int credit = bankEntity.getCredit();
        int result = credit - price;
        if (result < 0) {
            throw new CoffeeMachineException("Enter more money, please!");
        }
        updateBank(price);
        bankEntity.setCredit(result);
        log.info("Credit is {}", bankEntity.getCredit());
    }

    private void updateBank(int price) {
        int currentBank = bankEntity.getBank();
        bankEntity.setBank(currentBank + price);
        log.info("Bank is {}", bankEntity.getBank());
    }
}
