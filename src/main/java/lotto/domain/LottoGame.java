package lotto.domain;

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

}
