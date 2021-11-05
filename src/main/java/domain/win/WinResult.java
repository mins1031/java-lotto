package domain.win;

import domain.lotto.Lotto;
import domain.rank.Ranking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WinResult {
    private Map<Ranking, Integer> lottoResult = new HashMap<>();
    private int profitRate = 0;

    public void checkLottosResult(WinCondition winCondition, List<Lotto> lottos, int buyMoney) {
        lottos.stream().map(lotto -> Optional.ofNullable(Ranking.compareMatchCountAndBonusBall(winCondition.getLottoNums(), winCondition.getBonusBall(), lotto)))
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

    @Override
    public String toString() {
        return "당첨 통계 \n" +
                "--------- \n" +
                "3개 일치 (" + Ranking.FIVTH.getPrize() + ")- " + getCount(Ranking.FIVTH) + "개\n" +
                "4개 일치 (" + Ranking.FOURTH.getPrize() + ")- " + getCount(Ranking.FOURTH) + "개\n" +
                "5개 일치 (" + Ranking.THIRD.getPrize() + ")- " + getCount(Ranking.THIRD) + "개\n" +
                "5개, 보너스볼 일치 (" + Ranking.SECOND.getPrize() + ")- " + getCount(Ranking.SECOND) + "개\n" +
                "6개 일치 (" + Ranking.FIRST.getPrize() + ")- " + getCount(Ranking.FIRST) + "개\n" +
                "총 수익률은 " + profitRate + "입니다."
                ;
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
