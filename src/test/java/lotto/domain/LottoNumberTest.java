package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    public void LottoNumberTest() {
        Assertions.assertEquals(1, LottoNumber.from(1).getNumber());
        Assertions.assertEquals(45, LottoNumber.from(45).getNumber());
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumber.from(0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumber.from(46));
    }

}