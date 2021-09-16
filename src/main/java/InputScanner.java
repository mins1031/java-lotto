import java.util.List;
import java.util.Scanner;

public class InputScanner {

    private static Scanner scanner = new Scanner(System.in);

    public static int userNumberInput(String message) {
        System.out.println(message);
        String next = scanner.next();
        return Integer.parseInt(next);
    }

    public static List<String[]> userLottoInput(String message, int iter) {
        System.out.println(message);

        for(int i = 0; i < iter; ++i) {
            userLottoInput();
        }

    }

    public static String[] userLottoInput(){
        String inputNumbers = scanner.nextLine();
        return inputNumbers.split("\\s*,\\s*");
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
