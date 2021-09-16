package lotto.domain.lottos;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private List<LottoNo> numbers = new ArrayList<>();

    public LottoGame() {
    }

    public void addAll(List<LottoNo> lottoNos){
        numbers.addAll(lottoNos);
    }

    public void add(LottoNo lottoNos){
        numbers.add(lottoNos);
    }

    @Override
    public String toString() {
        return "" + numbers + "";
    }

    public List<LottoNo> getNumbers() {
        return numbers;
    }
}
