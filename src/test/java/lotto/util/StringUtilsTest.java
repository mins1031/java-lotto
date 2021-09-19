package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringUtilsTest {

    @DisplayName("숫자가 아닌값을 입력")
    @Test
    void notInteger() {
        String inputMoney = "a";
        assertThatThrownBy(() -> StringUtils.ToInt(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 문자를 입력하였습니다.");
    }
}
