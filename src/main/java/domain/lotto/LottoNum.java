package domain.lotto;

import java.util.Objects;

public class LottoNum {
    private final int num;

    private LottoNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public static LottoNum of(int num) {
        return new LottoNum(num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNum lottoNum = (LottoNum) o;
        return num == lottoNum.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
