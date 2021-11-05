package domain.win;

import domain.lotto.Lotto;
import domain.rank.Ranking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class WinResult {
    private Map<Ranking, Integer> lottoResult = new HashMap<>();
    private int profitRate = 0;

    public void checkLottosResult(WinCondition winCondition, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Ranking ranking = Ranking.compareMatchCountAndBonusBall(winCondition.getLottoNums(), winCondition.getBonusBall(), lotto);
            lottoResult.put(ranking, ranking.getPrize());
        }
    }

    public void calculateProfitRate(int buyMoney) {
        List<Integer> allPrizeList = lottoResult.values().stream().collect(Collectors.toList());
        int totalPrize = allPrizeList.stream().mapToInt(Integer::intValue).sum();
        profitRate = totalPrize / buyMoney;
    }

    public Map<Ranking, Integer> getLottoResult() {
        return lottoResult;
    }

    public int getProfitRate() {
        return profitRate;
    }

    public void setLottoResult(Map<Ranking, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }
}
