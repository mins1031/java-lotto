package lotto.domain;

import lotto.domain.previous.PreviousLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LottoTest {

    @Test
    public void LottoTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> PreviousLotto.of(Money.from(1000), -1));

        PreviousLotto lotto = PreviousLotto.of(Money.from(5000), 3);
        List<String> manualLottoList = new ArrayList<>();
        manualLottoList.add("1, 2, 3, 4, 5, 6");
        manualLottoList.add("1, 2, 3, 4, 5, 6");
        manualLottoList.add("1, 2, 3, 4, 5, 6");

        lotto.buyLottoManual(manualLottoList);
        Assertions.assertEquals(3, lotto.getManualLotto());
        Assertions.assertEquals(3, lotto.getManualLottoGames().size());

        lotto.buyLottoManual(manualLottoList);
        Assertions.assertEquals(3, lotto.getManualLotto());
        Assertions.assertEquals(3, lotto.getManualLottoGames().size());

        lotto.buyLottoAutomatic();
        Assertions.assertEquals(2, lotto.getAutoLotto());
        Assertions.assertEquals(2, lotto.getAutoLottoGames().size());

        lotto.buyLottoAutomatic();
        Assertions.assertEquals(2, lotto.getAutoLotto());
        Assertions.assertEquals(2, lotto.getAutoLottoGames().size());
    }

}
