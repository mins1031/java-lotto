package domain.lotto;

import exception.lotto.WrongInputNumsException;
import exception.lotto.OutsideInputNumException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumTest {

    @Test
    @DisplayName("입력받은 로또의 갯수가 6개가 아닐때")
    void name() {
        //given
        String lotto = "2, 5, 19, 20, 30";
        //when & then
        Assertions.assertThatThrownBy(() -> Lotto.toLottoNum(lotto)).isInstanceOf(WrongInputNumsException.class);
    }

    @Test
    @DisplayName("입력받은 로또넘버가 1~45 사이 수가 아닐때")
    void name2() {
        //given
        String lotto = "2, 5, 19, 20, 30, 46";
        //when & then
        Assertions.assertThatThrownBy(() -> Lotto.toLottoNum(lotto)).isInstanceOf(OutsideInputNumException.class);
    }

}