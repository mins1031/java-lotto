package lotto.domain.gambler;

import lotto.validator.BettingMoneyValidator;

public class BettingMoney {
    private final int bettingMoney;

    private BettingMoney(int bettingMoney) {
        this.bettingMoney = bettingMoney;
    }

    public static BettingMoney of(int bettingMoney) {
        BettingMoneyValidator.validate(bettingMoney);
        return new BettingMoney(bettingMoney);
    }

    public int calculateIncomeRate(long income) {
        return (int) (income * 100 / bettingMoney);
    }

    public int getBettingMoney() {
        return bettingMoney;
    }
}
