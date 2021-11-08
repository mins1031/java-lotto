package lotto.domain;

import lotto.validator.MoneyValidator;

public class Money {

    private final int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money from(int money) {
        MoneyValidator.validate(money);
        return new Money(money);
    }

    public int getMoney() {
        return money;
    }
}