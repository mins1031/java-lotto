package lotto.domain;

import lotto.domain.lottos.Lotto;
import lotto.domain.lottos.LottoGame;
import lotto.domain.lottos.LottoNo;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public class LottoCalcurator {

    public static WinResult calculateStatistic(WinInfo winInfo, Lotto lotto) {
        WinResult winResult = new WinResult();

        for (LottoGame lottoGame : lotto.getLottoGames()) {

            long matchCnt = lottoGame.getNumbers()
                    .stream()
                    .filter(x -> winInfo.getWinNumbers().getNumbers().contains(x))
                    .count();
            long bonusCnt = lottoGame.getNumbers()
                    .stream()
                    .filter(x -> x.equals(winInfo.getBonusBall()))
                    .count();

            winResult.distributeMatchCnt(matchCnt, bonusCnt);
        }
        return winResult;
    }

}
