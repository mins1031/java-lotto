package domain;

import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @Test
    void LottoNumberPrintTest() {
        LottoNumber lotto = new LottoNumber();
        lotto.add(1);
        lotto.add(2);
        lotto.add(3);
        lotto.add(4);
        lotto.add(5);
        lotto.add(6);

        System.out.println(lotto);
    }
}