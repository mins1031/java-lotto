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

    public static List<int[]> userLottoInput(int manualCount) {

        List<LottoGame> parseManualNumbers = new ArrayList<>();
        for(int i = 0; i < manualCount; ++i) {
            String inputNumbers = scanner.nextLine();

            List<Integer> tempInputs = Stream.of(inputNumbers.split("\\s*,\\s*")).distinct()
                    .map(x -> Integer.parseInt(x)).collect(Collectors.toList());

        }

        List<LottoNo> lottoNumbers = LottoNumbers.getInstance();
        List<LottoGame> lottoGames = new ArrayList<>();

        for (int [] intArray: parseManualNumbers) {
            LottoGame tempLottoGame = new LottoGame();
            Arrays.asList(intArray);
            if (lottoNumbers.contains(intArray)){
                lottoNumbers.get(intArray-1)
                lottoGames.add()
            }
            Stream.of(intArray).filter(x -> lottoNumbers.contains(x)).collect(Collectors.toList());
        }

        return parseManualNumbers;
    }

    public void validateDup(){

    }



}
