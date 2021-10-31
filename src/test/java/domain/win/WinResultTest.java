package domain.win;

import domain.lotto.Lotto;
import domain.lotto.LottoNum;
import domain.lotto.LottoNums;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WinResultTest {

    @Test
    void name() {
        //given
        List<LottoNum> firstLottoNums = Arrays.asList(
                LottoNum.of(20),
                LottoNum.of(13),
                LottoNum.of(5),
                LottoNum.of(33),
                LottoNum.of(9),
                LottoNum.of(39)
        );

        List<LottoNum> thirdLottoNums = Arrays.asList(
                LottoNum.of(20),
                LottoNum.of(13),
                LottoNum.of(5),
                LottoNum.of(33),
                LottoNum.of(45),
                LottoNum.of(42)
        );
        Lotto lotto1 = new Lotto();
        lotto1.addAll(firstLottoNums);
        Lotto lotto2 = new Lotto();
        lotto2.addAll(thirdLottoNums);

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto1);
        lottos.add(lotto2);

        WinCondition winCondition = new WinCondition(
                firstLottoNums,
                27
        );
        //when
        WinResult winResult = new WinResult();
        winResult.matchWinCount(winCondition, lottos);
        //then
        Assertions.assertThat(winResult.getFirstCount()).isEqualTo(1);
        Assertions.assertThat(winResult.getFourthCount()).isEqualTo(1);
    }
}