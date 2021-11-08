package lotto.validator;

public class MoneyValidator {
    public static String ERR_NEGATIVE_NOT_ALLOWED = "구매 금액은 음수가 될 수 없습니다.";

    public static void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(ERR_NEGATIVE_NOT_ALLOWED);
        }
    }
}
