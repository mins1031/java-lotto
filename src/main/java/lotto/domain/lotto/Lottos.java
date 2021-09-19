package lotto.domain.lotto;

import lotto.domain.result.LottoResult;
import lotto.domain.result.Rank;
import lotto.domain.winlotto.WinLotto;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResult checkResult(WinLotto winLotto) {
        List<Rank> ranks = compareRanks(winLotto);
        return new LottoResult(countRank(ranks));
    }

    private List<Rank> compareRanks(WinLotto winLotto) {
        return lottos.stream()
                .filter(lotto -> lotto.isWin(winLotto.getWinLotto()))
                .map(winLotto::findRank)
                .collect(Collectors.toList());
    }

    private TreeMap<Rank, Integer> countRank(List<Rank> ranks) {
        TreeMap<Rank, Integer> rankObjectTreeMap = new TreeMap<>(Comparator.comparing(Rank::getReward));
        for (Rank rank : ranks) {
            Integer count = Optional.ofNullable(rankObjectTreeMap.get(rank)).orElse(0);
            rankObjectTreeMap.put(rank, count + 1);
        }
        return rankObjectTreeMap;
    }
}
