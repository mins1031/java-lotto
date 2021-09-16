package lotto.scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InputScannerTest {

    @Test
    void validateTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> InputScanner.validateInput(Arrays.asList(1, 2, 3, 4, 6)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> InputScanner.validateInput(Arrays.asList(1, 2, 3, 4, 5, 66)));
    }

}