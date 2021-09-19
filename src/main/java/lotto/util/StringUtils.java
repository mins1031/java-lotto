package lotto.util;

import lotto.validator.InputValidator;

public class StringUtils {
    public static final String LINE_SEPARATOR = "\n";
    private static final String COMMA = ",";

    public static String[] splitByComma(String inputWinNumber) {
        return inputWinNumber.split(COMMA);
    }

    public static int ToInt(String inputNumber) {
        InputValidator.validateNumber(inputNumber);
        return Integer.parseInt(inputNumber);
    }
}
