import domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoUtilTest {

    @Test
    void manualNumParserTest(){
        //Given
        List<String> manualList = new ArrayList<>();
        manualList.add("1, 2, 3, 4, 5, 6");
        manualList.add("1, 2, 3, 4, 5, 8");
        manualList.add("1, 4, 5, 4, 5, 9");
        //When
        List<LottoNumber> parseResultList = LottoUtil.manualNumParser(manualList);
        //Then
        Assertions.assertThat(parseResultList.get(0).getLottoNumber()[0]).isEqualTo(1);
        Assertions.assertThat(parseResultList.get(0).getLottoNumber()[1]).isEqualTo(2);
        Assertions.assertThat(parseResultList.get(0).getLottoNumber()[2]).isEqualTo(3);
        Assertions.assertThat(parseResultList.get(1).getLottoNumber()[3]).isEqualTo(4);
        Assertions.assertThat(parseResultList.get(1).getLottoNumber()[4]).isEqualTo(5);
        Assertions.assertThat(parseResultList.get(1).getLottoNumber()[5]).isEqualTo(8);
        Assertions.assertThat(parseResultList.get(2).getLottoNumber()[1]).isEqualTo(4);
        Assertions.assertThat(parseResultList.get(2).getLottoNumber()[2]).isEqualTo(5);
        Assertions.assertThat(parseResultList.get(2).getLottoNumber()[5]).isEqualTo(9);
    }
}