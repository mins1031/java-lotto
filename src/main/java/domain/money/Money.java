package domain.money;

import exception.money.TotalMoneyException;

public class Money {
    private int buyMoney;

    public Money(String buyMoney) {
        this.buyMoney = toIntegerOfBuyMoney(buyMoney);
    }

    //구매금액에 대한 검증을 위한 메서드
    public int toIntegerOfBuyMoney(String inputBuyMoney) {
        try {
            int totalMoney = Integer.parseInt(inputBuyMoney);
            validateBuyMoney(totalMoney);
            return totalMoney;
        } catch (Exception e) {
            throw new TotalMoneyException("구매금액은 숫자여야 합니다.");
        }
    }

    private void validateBuyMoney(int buyMoney) {
        if (buyMoney <= 0) {
            throw new TotalMoneyException("구매금액은 1이상 어야 합니다.");
        }
    }

    public int getBuyMoney() {
        return buyMoney;
    }
}
