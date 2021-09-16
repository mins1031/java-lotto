package lotto.validator;

public class InputValidator {
    public static void numberInputValidate(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < 0) {
                throw new IllegalArgumentException("0이상의 숫자만 가능");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
