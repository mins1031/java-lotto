package lotto.domain;

public class Money {

    private final int money;

    private Money(int money) {
        this.money = money;
    }

    private static void validateMoney(int money) {
        if (money < 0){
            throw new IllegalArgumentException("구매 금액은 음수가 될 수 없습니다.");
        }
    }

    public static Money from(int money) {
        validateMoney(money);
        return new Money(money);
    }

    public int getMoney() {
        return money;
    }
}