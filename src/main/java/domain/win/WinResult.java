package domain.win;

import domain.lotto.Lotto;
import domain.lotto.LottoNum;
import domain.rank.Ranking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WinResult {
    private Map<Ranking, Integer> lottoResult = new HashMap<>();
    private int profitRate = 0;

    public void checkLottosResult(WinCondition winCondition, List<Lotto> lottos, int buyMoney) {
        List<LottoNum> winNumbers = winCondition.getWinNumbers();
        int bonusBall = winCondition.getBonusBall().getBonusBallNum();
        lottos.stream().map(lotto -> Optional.ofNullable(Ranking.compareMatchCountAndBonusBall(winNumbers, bonusBall, lotto)))
                .filter(ranking -> ranking.isPresent())
                .forEach(ranking -> lottoResult.put(ranking.get(), ranking.get().getPrize()));

        calculateProfitRate(buyMoney);
    }

    public void calculateProfitRate(int buyMoney) {
        int totalPrize = lottoResult.values().stream().mapToInt(Integer::intValue).sum();
        profitRate = totalPrize/ buyMoney;
    }

    public int getCount(Ranking ranking) {
        return (int) lottoResult.keySet().stream().filter(rank -> ranking.equals(rank)).count();
    }

    public int getProfitRate() {
        return profitRate;
    }

    public void setLottoResult(Map<Ranking, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }
}
