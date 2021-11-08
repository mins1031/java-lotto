package lotto.validator;

import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.List;

public class CustomerValidator {
    public static String ERR_TOO_MANY_LOTTO_COUNT = "구매 금액을 초과하여 로또를 구매하실 수 없습니다.";

    public static void validate(Money money, List<String> lottoNumbers) {
        if (money.getMoney() < lottoNumbers.size() * Lotto.LOTTO_PRICE) {
            throw new IllegalArgumentException(ERR_TOO_MANY_LOTTO_COUNT);
        }
    }
}
