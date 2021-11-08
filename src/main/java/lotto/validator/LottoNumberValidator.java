package lotto.validator;

import lotto.domain.LottoNumbers;

public class LottoNumberValidator {
    public static String ERR_NUMBER_OUT_OF_RANGE = LottoNumbers.MIN_LOTTO_NUM + "부터 " + LottoNumbers.MAX_LOTTO_NUM + "사이의 값을 입력해야 합니다.";

    public static void validate(int number) {
        if (number < LottoNumbers.MIN_LOTTO_NUM || number > LottoNumbers.MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(ERR_NUMBER_OUT_OF_RANGE);
        }
    }
}
