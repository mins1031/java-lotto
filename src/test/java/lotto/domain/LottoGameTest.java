package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    @Test
    public void LottoGameTest() {
        Assertions.assertEquals(6, LottoGame.newInstance().getNumbers().size());

        LottoGame lottoGame = LottoGame.parseLottoNumber("1, 2, 3, 4, 5, 6");
        Assertions.assertEquals(LottoMatch.ZERO, lottoGame.countMatch(LottoGame.parseLottoNumber("7, 8, 9, 10, 11, 12")));
        Assertions.assertEquals(LottoMatch.ONE, lottoGame.countMatch(LottoGame.parseLottoNumber("1, 8, 9, 10, 11, 12")));
        Assertions.assertEquals(LottoMatch.TWO, lottoGame.countMatch(LottoGame.parseLottoNumber("1, 2, 9, 10, 11, 12")));
        Assertions.assertEquals(LottoMatch.THREE, lottoGame.countMatch(LottoGame.parseLottoNumber("1, 2, 3, 10, 11, 12")));
        Assertions.assertEquals(LottoMatch.FOUR, lottoGame.countMatch(LottoGame.parseLottoNumber("1, 2, 3, 4, 11, 12")));
        Assertions.assertEquals(LottoMatch.FIVE, lottoGame.countMatch(LottoGame.parseLottoNumber("1, 2, 3, 4, 5, 12")));
        Assertions.assertEquals(LottoMatch.SIX, lottoGame.countMatch(LottoGame.parseLottoNumber("1, 2, 3, 4, 5, 6")));

        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoGame.parseLottoNumber("1, 1, 2, 3, 4, 5"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoGame.parseLottoNumber("0, 1, 2, 3, 4, 5"));
    }

}