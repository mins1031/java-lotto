package domain.lotto;

import exception.InputLottoCountException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LottoMarketTest {

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
        LottoMarket lottoMarket = new LottoMarket();
        lottoMarket.saveManualLottoNums(rawManualLottos);

        //then
        Assertions.assertThat(lottoMarket.getLottos()).hasSize(3);
        Assertions.assertThat(lottoMarket.getLottos().get(0).getLotto().get(0).getNum()).isEqualTo(8);
        Assertions.assertThat(lottoMarket.getLottos().get(0).getLotto().get(1).getNum()).isEqualTo(21);
        Assertions.assertThat(lottoMarket.getLottos().get(0).getLotto().get(2).getNum()).isEqualTo(23);
        Assertions.assertThat(lottoMarket.getLottos().get(0).getLotto().get(3).getNum()).isEqualTo(41);
        Assertions.assertThat(lottoMarket.getLottos().get(0).getLotto().get(4).getNum()).isEqualTo(42);
        Assertions.assertThat(lottoMarket.getLottos().get(0).getLotto().get(5).getNum()).isEqualTo(43);
        Assertions.assertThat(lottoMarket.getLottos().get(1).getLotto().get(0).getNum()).isEqualTo(3);
        Assertions.assertThat(lottoMarket.getLottos().get(1).getLotto().get(1).getNum()).isEqualTo(5);
        Assertions.assertThat(lottoMarket.getLottos().get(1).getLotto().get(2).getNum()).isEqualTo(11);
        Assertions.assertThat(lottoMarket.getLottos().get(1).getLotto().get(3).getNum()).isEqualTo(16);
        Assertions.assertThat(lottoMarket.getLottos().get(1).getLotto().get(4).getNum()).isEqualTo(32);
        Assertions.assertThat(lottoMarket.getLottos().get(1).getLotto().get(5).getNum()).isEqualTo(38);
        Assertions.assertThat(lottoMarket.getLottos().get(2).getLotto().get(0).getNum()).isEqualTo(7);
        Assertions.assertThat(lottoMarket.getLottos().get(2).getLotto().get(1).getNum()).isEqualTo(11);
        Assertions.assertThat(lottoMarket.getLottos().get(2).getLotto().get(2).getNum()).isEqualTo(16);
        Assertions.assertThat(lottoMarket.getLottos().get(2).getLotto().get(3).getNum()).isEqualTo(35);
        Assertions.assertThat(lottoMarket.getLottos().get(2).getLotto().get(4).getNum()).isEqualTo(36);
        Assertions.assertThat(lottoMarket.getLottos().get(2).getLotto().get(5).getNum()).isEqualTo(44);
    }

    @Test
    @DisplayName("[예외]수동 로또 수를 5개 준 경우")
    void saveManualLottoNumsTest2() {
        //given
        String raw1 = "8, 21, 23, 41, 42";
        String raw2 = "3, 5, 11, 16, 32, 38";
        String raw3 = "7, 11, 16, 35, 36, 44";

        List<String> rawManualLottos = new ArrayList<>();
        rawManualLottos.add(raw1);
        rawManualLottos.add(raw2);
        rawManualLottos.add(raw3);
        //when
        LottoMarket lottoMarket = new LottoMarket();

        //then
        Assertions.assertThatThrownBy(() ->
                lottoMarket.saveManualLottoNums(rawManualLottos))
                .isInstanceOf(InputLottoCountException.class);
    }

    @Test
    @DisplayName("[예외]수동 로또 수를 7개 준 경우")
    void saveManualLottoNumsTest3() {
        //given
        String raw1 = "8, 21, 23, 41, 42, 43, 45";
        String raw2 = "3, 5, 11, 16, 32, 38";
        String raw3 = "7, 11, 16, 35, 36, 44";

        List<String> rawManualLottos = new ArrayList<>();
        rawManualLottos.add(raw1);
        rawManualLottos.add(raw2);
        rawManualLottos.add(raw3);
        //when
        LottoMarket lottoMarket = new LottoMarket();

        //then
        Assertions.assertThatThrownBy(() ->
                lottoMarket.saveManualLottoNums(rawManualLottos))
                .isInstanceOf(InputLottoCountException.class);
    }

    @Test
    void autoGenerateLottoTest() {
        //given
        int autoLottoCount = 5;
        //when
        LottoMarket lottoMarket = new LottoMarket();
        lottoMarket.generateAutoLottos(autoLottoCount);
        //then
        Assertions.assertThat(lottoMarket.getLottos()).hasSize(5);
        Assertions.assertThat(LottoNums.getLottoNumList())
                .contains(lottoMarket.getLottos().get(0).getLotto().get(0));
    }

    @Test
    void toLottoNumTest() {
        //given
        String rawNums = "31, 28, 5, 20, 45, 1";
        LottoMarket lottoMarket = new LottoMarket();
        //when
        List<LottoNum> lottoNums = lottoMarket.toLottoNum(rawNums);
        //then
        Assertions.assertThat(lottoNums).hasSize(6);
        Assertions.assertThat(lottoNums.get(0).getNum()).isEqualTo(31);
        Assertions.assertThat(lottoNums.get(1).getNum()).isEqualTo(28);
        Assertions.assertThat(lottoNums.get(2).getNum()).isEqualTo(5);
        Assertions.assertThat(lottoNums.get(3).getNum()).isEqualTo(20);
        Assertions.assertThat(lottoNums.get(4).getNum()).isEqualTo(45);
        Assertions.assertThat(lottoNums.get(5).getNum()).isEqualTo(1);
    }
}