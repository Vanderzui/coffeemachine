package org.vanderzui.cofeemachine.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankEntity {
    public static final int BANK_MIN_MONEY_COUNT = 100;
    public static final int BANK_INIT_MONEY_COUNT = 1000;

    private int bank;
    private int credit;
}
