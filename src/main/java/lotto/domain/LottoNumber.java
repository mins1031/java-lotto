package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int number ;

    private LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("LottoNumber must be 1 to 45");
        }
    }

    public static LottoNumber from(int number) {
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
