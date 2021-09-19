package lotto.validator;

import static lotto.domain.lotto.Lotto.LOTTO_PRICE;

public class ManualLottoCountValidator {
    public static final String ERROR_MESSAGE_OVER_COUNT = "구입 가능한 수보다 큰 수를 입력하였습니다.";

    public static void validate(int bettingMoney,int manualLottoCount) {
        int canBuyLottoCount = bettingMoney / LOTTO_PRICE;
        if (manualLottoCount > canBuyLottoCount) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OVER_COUNT);
        }
    }

}
