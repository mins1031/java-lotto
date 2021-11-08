package lotto.domain;

import lotto.validator.LottoNumberValidator;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;

    private static final Random rand;
    private static final List<LottoNumber> lottoNumbers;

    static {
        rand = new Random(System.currentTimeMillis());
        lottoNumbers = IntStream.rangeClosed(MIN_LOTTO_NUM, MAX_LOTTO_NUM).mapToObj(LottoNumber::from).collect(Collectors.toList());
    }

    public static LottoNumber getNumber(int number) {
        LottoNumberValidator.validate(number);
        return lottoNumbers.get(number - 1);
    }

    public static LottoNumber getRandomNumber() {
        return getNumber(rand.nextInt(45) + 1);
    }
}
