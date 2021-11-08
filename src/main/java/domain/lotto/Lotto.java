package domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private List<LottoNum> lotto = new ArrayList<>();
    public static final int LOTTOS_SIZE = 6;
    public static final int LOTTO_PRICE = 1000;

    public List<LottoNum> getLotto() {
        return lotto;
    }

    public void add(LottoNum lottoNum) {
        lotto.add(lottoNum);
    }

    public void addAll(List<LottoNum> lottoNums) {
        lotto.addAll(lottoNums);
    }

    @Override
    public String toString() {
        return "[" +
                lotto.get(0).getNum() + ", " +
                lotto.get(1).getNum() + ", " +
                lotto.get(2).getNum() + ", " +
                lotto.get(3).getNum() + ", " +
                lotto.get(4).getNum() + ", " +
                lotto.get(5).getNum() + "]"
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
