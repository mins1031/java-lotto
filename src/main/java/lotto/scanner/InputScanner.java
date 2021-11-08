package lotto.scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InputScanner {
    private static final Scanner scanner = new Scanner(System.in);

    // 숫자 입력
    public static int inputNumeric(String message) {
        System.out.println(message);
        return Integer.parseInt(scanner.nextLine());
    }

    // 라인 입력
    public static String inputString(String message) {
        return inputStrings(message, 1).get(0);
    }

    // 멀티 라인 입력
    public static List<String> inputStrings(String message, int iterator) {
        System.out.println(message);
        return IntStream.range(0, iterator).mapToObj(x -> scanner.nextLine()).collect(Collectors.toList());
    }
}
