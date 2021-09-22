package lotto.scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputScanner {
    private static final Scanner scanner = new Scanner(System.in);

    // 숫자 입력
    public static int inputNumeric(String message) {
        System.out.println(message);
        String next = scanner.next();
        scanner.nextLine(); // remove '\n'
        return Integer.parseInt(next);
    }

    // 라인 입력
    public static String inputString(String message) {
        return inputStrings(message, 1).get(0);
    }

    // 멀티 라인 입력
    public static List<String> inputStrings(String message, int iterator) {
        System.out.println(message);
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < iterator; ++i) {
            strings.add(scanner.nextLine());
        }
        return strings;
    }
}
