package lotto.scanner;

import lotto.domain.LottoGame;
import lotto.domain.LottoNo;
import lotto.domain.LottoNumbers;
import lotto.exception.ExceptionHandler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputScanner {

    private static Scanner scanner = new Scanner(System.in);

    public static int userNumberInput(String message) {
        System.out.println(message);
        String next = scanner.next();
        return Integer.parseInt(next);
    }

    public static List<LottoGame> userLottoInput(int manualCount) {

        List<LottoNo> lottoNumbers = LottoNumbers.getInstance();
        List<LottoGame> parseManualNumbers = new ArrayList<>();

        for(int i = 0; i < manualCount; ++i) {
            String inputNumbers = scanner.nextLine();

            List<Integer> tempInputs = Stream.of(inputNumbers.split("\\s*,\\s*"))
                    .distinct()
                    .map(Integer::parseInt).collect(Collectors.toList());

            validateInput(tempInputs);

            List<LottoNo> numList = tempInputs.stream().map(x -> lottoNumbers.get(x - 1)).collect(Collectors.toList());
            LottoGame game = new LottoGame();
            game.addAll(numList);
            parseManualNumbers.add(game);
        }

        return parseManualNumbers;
    }

    public static void validateInput(List<Integer> input) {
        List<Integer> inRangeValidate = input.stream().filter(x -> (x > 0 && x < 46)).collect(Collectors.toList());
        if (input.size() != 6) {
            throw new IllegalArgumentException("중복된 숫자는 입력하실 수 없습니다.");
        }
        if (inRangeValidate.size() != 6) {
            throw new IllegalArgumentException("1 - 45 이내의 숫자만 입력하실 수 있습니다.");
        }
    }



}
