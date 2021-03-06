package domain;

import exception.lotto.OutRangeInputManualLottoCount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyerTest {

    @Test
    @DisplayName("[예외] 수동 로또수가 전체 로또 수보다 많은 경우")
    void name() {
        //given
        String buyMoney = "15000";
        Buyer buyer = new Buyer(buyMoney);
        String rawManualNum = "16";
        //when & then
        Assertions.assertThatThrownBy(() -> buyer.defineAllLottoCountTypes(rawManualNum))
                .isInstanceOf(OutRangeInputManualLottoCount.class);
    }
}