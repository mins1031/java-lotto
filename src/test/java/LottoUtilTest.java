import domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoUtilTest {

    @Test
    void lottoNumberParserTest(){
        //Given
        String testLotto = "1, 4, 5, 4, 5, 9";
        //When
        LottoNumber parseLottoData = LottoUtil.lottoNumberParser(testLotto);
        //Then
        Assertions.assertThat(parseLottoData.getLottoNumber().get(0)).isEqualTo(1);
        Assertions.assertThat(parseLottoData.getLottoNumber().get(1)).isEqualTo(4);
        Assertions.assertThat(parseLottoData.getLottoNumber().get(2)).isEqualTo(5);
        Assertions.assertThat(parseLottoData.getLottoNumber().get(3)).isEqualTo(4);
        Assertions.assertThat(parseLottoData.getLottoNumber().get(4)).isEqualTo(5);
        Assertions.assertThat(parseLottoData.getLottoNumber().get(5)).isEqualTo(9);

    }

    @Test
    void autoNumCreateTest() {
        //Given
        int autoLottoCount = 11;
        //When
        List<LottoNumber> autoNumbers = LottoUtil.autoNumCreate(autoLottoCount);
        //Then
        Assertions.assertThat(autoNumbers.size()).isEqualTo(11);
    }
}