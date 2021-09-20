import lotto.domain.lottos.Lotto;
import lotto.domain.lottos.LottoGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

public class LottoTest {

    @Test
    @Disabled
    void manualNumCreateTest(){

        String input1 = "1";
        String input2 = "8, 21, 23, 41, 42, 43";
        String input3 = "3, 5, 11, 16, 32, 38";
        String input4 = "7, 11, 16, 35, 36, 44";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        InputStream in = new ByteArrayInputStream(input1.getBytes());
        System.setIn(in);
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);

        //Given & When
        // List<LottoNumber> lottoList = LottoUtil.manualNumCreate();
        //Then
        // Assertions.assertThat(lottoList.size()).isEqualTo(3);

    }

    @Test
    void createAutoLottoTest() {
        int autoLottoCount = 5;

        Lotto lotto = new Lotto();
        lotto.createAutoLotto(autoLottoCount);
        List<LottoGame> autoLotto = lotto.getLottoGames();

        for (LottoGame temp: autoLotto) {
            System.out.println(temp);
        }

        Assertions.assertThat(autoLotto.size()).isEqualTo(5);
    }

    @Test
    void printTest() {
        Lotto lotto = new Lotto();
        lotto.createAutoLotto(7);

        lotto.print();



    }

}
