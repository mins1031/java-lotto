package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<LottoNum> lotto = new ArrayList<>();

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
}
