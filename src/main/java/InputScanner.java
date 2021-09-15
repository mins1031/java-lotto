import java.util.InputMismatchException;
import java.util.Scanner;

public class InputScanner {

    private static Scanner scan = new Scanner(System.in);

    public static int scanInteger(){
        int input = 0;
        try {
            input = scan.nextInt();
            if (input <= 0){
                generateInputError();
            }
        } catch (RuntimeException e) {
            generateInputError();
        }
        return input;
    }

    public String scanString(){
        return scan.nextLine();
    }

    private static void generateInputError(){
        System.out.println("잘못된 입력입니다. 프로그램을 다시 실행해주세요");
        System.exit(1);
    }



}
