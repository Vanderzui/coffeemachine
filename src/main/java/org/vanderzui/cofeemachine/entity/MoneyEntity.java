package org.vanderzui.cofeemachine.entity;

public class MoneyEntity {
    public static final int BANK_MIN_MONEY_COUNT = 100;
    public static final int BANK_INIT_MONEY_COUNT = 1000;

    private int bank;
    private int credit;

    public MoneyEntity(int bank) {
        this.bank = bank;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
