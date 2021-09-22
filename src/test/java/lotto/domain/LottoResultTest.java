package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @Test
    public void LottoResultTest() {
        Lotto lotto = Lotto.of(Money.from(8000), 8);
        List<String> manualLottoList = new ArrayList<>();
        manualLottoList.add("1, 2, 3, 4, 5, 6");
        manualLottoList.add("2, 3, 4, 5, 6, 7");
        manualLottoList.add("3, 4, 5, 6, 7, 8");
        manualLottoList.add("4, 5, 6, 7, 8, 9");
        manualLottoList.add("5, 6, 7, 8, 9, 10");
        manualLottoList.add("6, 7, 8, 9, 10, 11");
        manualLottoList.add("7, 8, 9, 10, 11, 12");
        manualLottoList.add("2, 3, 4, 5, 6, 13");

        String winningLotto = "1, 2, 3, 4, 5, 6";
        int bonusBall = 13;

        lotto.buyLottoManual(manualLottoList);

        LottoResult lottoResult = LottoResult.of(lotto, winningLotto, bonusBall);

        for (int i = 0; i < 8; ++i) {
            Assertions.assertEquals(1, lottoResult.getMatchArray()[i]);
        }

        Assertions.assertEquals(253944.375, lottoResult.getBenefitRate());
    }
}