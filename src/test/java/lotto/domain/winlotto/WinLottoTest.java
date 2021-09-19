package lotto.domain.winlotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WinLottoTest {
    @DisplayName("winLotto 생성 테스트")
    @Test
    void of() {
        WinLotto winLotto = WinLotto.of(Arrays.asList("1", "2", "3", "4", "15", "19"), "40");

        Assertions.assertThat(winLotto.getWinLotto()).isEqualTo(Lotto.of(Arrays.asList(
                LottoNo.toLottoNo(1),
                LottoNo.toLottoNo(2),
                LottoNo.toLottoNo(3),
                LottoNo.toLottoNo(4),
                LottoNo.toLottoNo(15),
                LottoNo.toLottoNo(19)
        )));
        Assertions.assertThat(winLotto.getBonusBall()).isEqualTo(new BonusBall(LottoNo.toLottoNo(40)));
    }

    @DisplayName("[예외] winLotto 생성시 보너스볼이 당첨번호에 포홤된 경우")
    @Test
    void of2() {
        Assertions.assertThatThrownBy(() -> WinLotto.of(Arrays.asList("1", "2", "3", "4", "15", "19"), "3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}