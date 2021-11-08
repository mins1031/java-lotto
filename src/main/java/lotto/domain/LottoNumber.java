package lotto.domain;

import lotto.validator.LottoNumberValidator;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        LottoNumberValidator.validate(number);
        return new LottoNumber(number);
    }

    @Override
    public int compareTo(LottoNumber number) {
        return this.getNumber() - number.getNumber();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int getNumber() {
        return number;
    }
}
