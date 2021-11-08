package lotto.validator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;

public class LottoValidator {
    public static String ERR_SIZE_NOT_ENOUGH = "입력된 숫자가 6개 미만입니다.";

    public static void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException(ERR_SIZE_NOT_ENOUGH);
        }
    }
}
