package domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BuyLottosTest {

    @Test
    @DisplayName("수동 로또를 문자열 형태로 입력받아 진짜 리스트로 만들기")
    void saveManualLottoNumsTest() {
        //given
        String raw1 = "8, 21, 23, 41, 42, 43";
        String raw2 = "3, 5, 11, 16, 32, 38";
        String raw3 = "7, 11, 16, 35, 36, 44";

        List<String> rawManualLottos = new ArrayList<>();
        rawManualLottos.add(raw1);
        rawManualLottos.add(raw2);
        rawManualLottos.add(raw3);
        //when
        BuyLottos buyLottos = new BuyLottos();
        List<LottoNum> lottoNums = buyLottos.saveManualLottoNums(rawManualLottos);

        //then
        Assertions.assertThat(lottoNums).hasSize(3);
        Assertions.assertThat(lottoNums.get(0).getClass()).isEqualTo(LottoNum.class);
    }
}