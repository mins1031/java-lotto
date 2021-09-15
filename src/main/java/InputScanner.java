import validator.InputValidator;

import java.util.Scanner;

public class InputScanner {

    private static Scanner scanner = new Scanner(System.in);

    public static int userNumberInput(String message) {
        System.out.println(message);
        String next = scanner.next();
        InputValidator.numberInputValidate(next);
        return Integer.parseInt(next);
    }

    public static int scanInteger() {
        int input = 0;
        try {
            input = scanner.nextInt();
            if (input <= 0) {
                ExceptionHandler.generateInputError();
            }
        } catch (RuntimeException e) {
            ExceptionHandler.generateInputError();
        }
        return input;
    }

    public static String scanString() {
        String input = scanner.nextLine();

        // input.length() == 0


        // 6개 이외의 입력

        return input;
    }


}
