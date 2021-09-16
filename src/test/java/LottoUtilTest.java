import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoUtilTest {

    @Test
    void lottoNumberParserTest(){
        //Given
        String testLotto = "1, 4, 5, 4, 5, 9";
        //When
        List<Integer> parseLottoData = LottoUtil.lottoNumberParser(testLotto);
        //Then
        Assertions.assertThat(parseLottoData.get(0)).isEqualTo(1);
        Assertions.assertThat(parseLottoData.get(1)).isEqualTo(4);
        Assertions.assertThat(parseLottoData.get(2)).isEqualTo(5);
        Assertions.assertThat(parseLottoData.get(3)).isEqualTo(4);
        Assertions.assertThat(parseLottoData.get(4)).isEqualTo(5);
        Assertions.assertThat(parseLottoData.get(5)).isEqualTo(9);
    }

    @Test
    void autoNumCreateTest() {
        //Given
        int autoLottoCount = 11;
        //When
        List<Lotto> autoNumbers = LottoUtil.autoNumCreate(autoLottoCount);
        //Then
        Assertions.assertThat(autoNumbers.size()).isEqualTo(11);
    }
}