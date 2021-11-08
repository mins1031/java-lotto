package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LottoResult {
    private List<LottoGenerator> lottoGenerators;
    private WinLotto winningLotto;
    private Map<Rank, Integer> result;

    private LottoResult(List<LottoGenerator> lottoGenerators, WinLotto winningLotto) {
        this.lottoGenerators = lottoGenerators;
        this.winningLotto = winningLotto;
        result  = new TreeMap<>();
    }

    private void initResult() {
        for(LottoGenerator lottoGenerator : lottoGenerators) {

        }
    }

    public static LottoResult of (List<LottoGenerator> lottoGenerators, WinLotto winningLotto) {
        return new LottoResult(lottoGenerators, winningLotto);
    }


}
