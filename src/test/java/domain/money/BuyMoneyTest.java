package domain.money;

import exception.money.TotalMoneyException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyMoneyTest {

    @Test
    @DisplayName("[예외] 구매금액이 0 인경우")
    void name() {
        //given
        String rawBuyMoney = "0";
        //when & then
        Assertions.assertThatThrownBy(() -> new BuyMoney(rawBuyMoney)).isInstanceOf(TotalMoneyException.class);
    }

    @Test
    @DisplayName("[예외] 구매금액이 음수 인경우")
    void name2() {
        //given
        String rawBuyMoney = "-100";
        //when & then
        Assertions.assertThatThrownBy(() -> new BuyMoney(rawBuyMoney)).isInstanceOf(TotalMoneyException.class);
    }

    @Test
    @DisplayName("[예외] 구매금액이 문자 인경우")
    void name3() {
        //given
        String rawBuyMoney = "char";
        //when & then
        Assertions.assertThatThrownBy(() -> new BuyMoney(rawBuyMoney)).isInstanceOf(TotalMoneyException.class);
    }
}