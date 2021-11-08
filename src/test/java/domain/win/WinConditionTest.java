package domain.win;

import domain.bonusball.BonusBall;
import domain.lotto.LottoNum;
import exception.win.DuplicateBonusBallWithWinNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class WinConditionTest {

    @Test
    @DisplayName("[예외] 보너스볼이 당첨번호와 중복되는 경우")
    void name() {
        //given
        int[] rawWinnums = {5, 16, 20, 25, 36, 39};
        List<LottoNum> winNums = Arrays.stream(rawWinnums).mapToObj(num -> LottoNum.of(num)).collect(Collectors.toList());
        int bonusBall = 5;
        //when & then
        Assertions.assertThatThrownBy(() -> new WinCondition(winNums, new BonusBall(bonusBall)))
                .isInstanceOf(DuplicateBonusBallWithWinNumbers.class);
    }
}