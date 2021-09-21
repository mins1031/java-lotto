package lotto.domain.lottos;

import java.util.Objects;

public class LottoNo implements Comparable<LottoNo> {
    private int number ;

    public LottoNo(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return  Integer.toString(number);
    }

    @Override
    public int compareTo(LottoNo num) {
        return this.getNumber() - num.getNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
