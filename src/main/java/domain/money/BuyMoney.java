package domain.money;

import domain.Buyer;
import exception.TotalMoneyException;
import scanner.InputValidation;

public class BuyMoney {
    private int totalBuyMoney;

    public BuyMoney(String totalBuyMoney) {
        this.totalBuyMoney = toIntegerOfBuyMoney(totalBuyMoney);
    }

    //구매금액에 대한 검증을 위한 메서드
    public int toIntegerOfBuyMoney (String inputBuyMoney) {
        try {
            int totalMoney = Integer.parseInt(inputBuyMoney);
            InputValidation.validateBuyMoney(totalMoney);
            return totalMoney;
        } catch (Exception e) {
            throw new TotalMoneyException("구매금액은 숫자여야 합니다.");
        }
    }

    public int getTotalBuyMoney() {
        return totalBuyMoney;
    }
}
