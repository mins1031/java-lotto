import java.util.InputMismatchException;
import java.util.Scanner;

public class InputScanner {

    private static Scanner scan = new Scanner(System.in);

    public static int scanInteger() {
        int input = 0;
        try {
            input = scan.nextInt();
            if (input <= 0){
                ExceptionHandler.generateInputError();
            }
        } catch (RuntimeException e) {
            ExceptionHandler.generateInputError();
        }
        return input;
    }

    public static String scanString() {
        String input = scan.nextLine();

        // input.length() == 0


        // 6개 이외의 입력

        return input;
    }




}
