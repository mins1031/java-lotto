package lotto.domain;

import lotto.domain.lottos.Lotto;
import lotto.domain.lottos.LottoGame;
import lotto.domain.lottos.LottoNo;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public class LottoCalcurator {

    private List<LottoGame> lottoList;
    private LottoGame winNumbers;
    private LottoNo bonusBall;

    private LottoCalcurator(WinInfo winInfo, Lotto lotto){
        lottoList = lotto.getLottoGames();
        winNumbers = winInfo.getWinNumbers();
        bonusBall = winInfo.getBonusBall();
    }

    public static WinResult calculateStatistic(WinInfo winInfo, Lotto lotto) {
        LottoCalcurator lottoCalcurator = new LottoCalcurator();
        WinResult winResult = new WinResult();

        for (LottoGame lottoGame : lottoList) {
            int matchCnt = 0;
            int bonusCnt = 0;
            for (LottoNo lottoNo : lottoGame.getNumbers()) {
                //생성된 6자리들을 하나하나보는 포문
                if (winNumbers.getNumbers().contains(lottoNo.getNumber())){
                    //생성된 로또번호가 당첨번호 리스트에 포함 되어있는지 확인
                    matchCnt++;
                }

                if (lottoNo.getNumber() == bonusBall.getNumber()){
                    //생성된 로또번호가 보너스번호화 일치하는지 확인
                    bonusCnt++;
                }
            }

            winResult.distributeMatchCnt(matchCnt, bonusCnt);

        }

        return winResult;
    }

}
