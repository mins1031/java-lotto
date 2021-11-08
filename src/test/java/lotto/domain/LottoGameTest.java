package lotto.domain;

import lotto.domain.previous.PreviousLottoGame;
import lotto.domain.previous.PreviousRank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    @Test
    public void LottoGameTest() {
        Assertions.assertEquals(6, PreviousLottoGame.newInstance().getNumbers().size());

        PreviousLottoGame lottoGame = PreviousLottoGame.parseLottoNumber("1, 2, 3, 4, 5, 6");
        Assertions.assertEquals(PreviousRank.ZERO, lottoGame.countMatch(PreviousLottoGame.parseLottoNumber("7, 8, 9, 10, 11, 12")));
        Assertions.assertEquals(PreviousRank.ONE, lottoGame.countMatch(PreviousLottoGame.parseLottoNumber("1, 8, 9, 10, 11, 12")));
        Assertions.assertEquals(PreviousRank.TWO, lottoGame.countMatch(PreviousLottoGame.parseLottoNumber("1, 2, 9, 10, 11, 12")));
        Assertions.assertEquals(PreviousRank.THREE, lottoGame.countMatch(PreviousLottoGame.parseLottoNumber("1, 2, 3, 10, 11, 12")));
        Assertions.assertEquals(PreviousRank.FOUR, lottoGame.countMatch(PreviousLottoGame.parseLottoNumber("1, 2, 3, 4, 11, 12")));
        Assertions.assertEquals(PreviousRank.FIVE, lottoGame.countMatch(PreviousLottoGame.parseLottoNumber("1, 2, 3, 4, 5, 12")));
        Assertions.assertEquals(PreviousRank.SIX, lottoGame.countMatch(PreviousLottoGame.parseLottoNumber("1, 2, 3, 4, 5, 6")));

        Assertions.assertThrows(IllegalArgumentException.class, () -> PreviousLottoGame.parseLottoNumber("1, 1, 2, 3, 4, 5"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> PreviousLottoGame.parseLottoNumber("0, 1, 2, 3, 4, 5"));
    }

}