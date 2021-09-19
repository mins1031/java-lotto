package lotto.validator;

import lotto.domain.lotto.Lotto;

public class BettingMoneyValidator {
    public static final int MIN_BETTING_MONEY = 0;
    public static final String ERROR_MESSAGE_UNDER_ZERO_MONEY = "베팅 금액은 0보다 작을 수 없습니다.";
    public static final String ERROR_MESSAGE_MIN_MONEY = Lotto.LOTTO_PRICE + "이상의 금액만 가능합니다.";

    public static void validate(int bettingMoney) {
        if (bettingMoney < MIN_BETTING_MONEY) {
            throw new IllegalArgumentException(ERROR_MESSAGE_UNDER_ZERO_MONEY);
        }
        if (bettingMoney < Lotto.LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MIN_MONEY);
        }
    }
}
