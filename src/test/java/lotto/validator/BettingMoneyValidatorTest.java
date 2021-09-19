package lotto.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BettingMoneyValidatorTest {

    @DisplayName("예외 발생하지 않음")
    @Test
    void validate0() {
        BettingMoneyValidator.validate(2000);
    }

    @DisplayName("[예외]0 미만의 금액을 입력했을 경우")
    @Test
    void validate1() {
        Assertions.assertThatThrownBy(() -> BettingMoneyValidator.validate(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BettingMoneyValidator.ERROR_MESSAGE_UNDER_ZERO_MONEY);
    }

    @DisplayName("[예외]1000 미만의 금액을 입력했을 경우")
    @Test
    void validate2() {
        Assertions.assertThatThrownBy(() -> BettingMoneyValidator.validate(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BettingMoneyValidator.ERROR_MESSAGE_MIN_MONEY);
    }
}