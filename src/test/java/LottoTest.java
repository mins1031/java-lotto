import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoTest {

    @Test
    void manualNumCreateTest(){
        //Given & When
        List<String> lottoList = LottoUtil.manualNumCreate();
        //Then
        Assertions.assertEquals(lottoList.size(), 3);

    }
}
