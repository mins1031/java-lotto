package domain.win;

import domain.lotto.Lotto;
import domain.rank.Ranking;

import java.util.List;
import java.util.TreeMap;

public class WinResult {
    private TreeMap<Ranking, Integer> lottoResult = new TreeMap<>();

    public void matchWinCount(WinCondition winCondition, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Ranking ranking = Ranking.compareMatchCountAndBonusBall(winCondition.getLottoNums(), winCondition.getBonusBall(), lotto);
        }
    }


}
