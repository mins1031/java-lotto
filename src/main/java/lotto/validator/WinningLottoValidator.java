package lotto.validator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class WinningLottoValidator {
    public static String ERR_BONUS_CONTAINS_NOT_ALLOWED = "당첨 번호에 보너스 볼이 포함될 수 없습니다.";

    public static void validate(Lotto winningLotto, LottoNumber bonusBall) {
        if (winningLotto.contains(bonusBall)) {
            throw new IllegalArgumentException(ERR_BONUS_CONTAINS_NOT_ALLOWED);
        }
    }
}
