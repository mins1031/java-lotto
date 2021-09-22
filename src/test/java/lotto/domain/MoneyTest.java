package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    public void moneyTest() {
        Assertions.assertEquals(1000, Money.from(1000).getMoney());
        Assertions.assertThrows(IllegalArgumentException.class, () -> Money.from(-1000));
    }
}