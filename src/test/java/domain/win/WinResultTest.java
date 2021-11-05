package domain.win;

import domain.rank.Ranking;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class WinResultTest {

    @Test
    @DisplayName("수익률 추출 테스트")
    void name() {
        //given
        Map<Ranking, Integer> rankings = new HashMap<>();
        rankings.put(Ranking.SECOND, Ranking.SECOND.getPrize());
        rankings.put(Ranking.FOURTH, Ranking.FOURTH.getPrize());
        int buyMoney = 10000;
        int winPrize = Ranking.SECOND.getPrize() + Ranking.FOURTH.getPrize();
        //when
        WinResult winResult = new WinResult();
        winResult.setLottoResult(rankings);
        winResult.calculateProfitRate(buyMoney);
        //then
        Assertions.assertThat(winResult.getProfitRate()).isEqualTo(winPrize / buyMoney);
    }

    @Test
    @DisplayName("로또 순위 일치 갯수 테스트")
    void name2() {
        //given
        Map<Ranking, Integer> rankings = new HashMap<>();
        rankings.put(Ranking.SECOND, Ranking.SECOND.getPrize());
        rankings.put(Ranking.FOURTH, Ranking.FOURTH.getPrize());
        //when
        WinResult winResult = new WinResult();
        winResult.setLottoResult(rankings);
        Integer rankMatchCount = winResult.getCount(Ranking.FOURTH);
        //then
        Assertions.assertThat(rankMatchCount).isEqualTo(1);
    }
}