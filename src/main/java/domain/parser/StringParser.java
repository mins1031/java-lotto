package domain.parser;

import exception.InputLottoCountException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    private static final String RAW_LOTTO_NUM_PARSE_STAND = ", ";

    public static List<Integer> parseInputLottoNums(String rawInputNums) {
        String[] inputNums = rawInputNums.split(RAW_LOTTO_NUM_PARSE_STAND);
        if (inputNums.length != 6) {
            throw new InputLottoCountException();
        }
        return Arrays.asList(inputNums).stream()
                .map(num -> Integer.parseInt(num))
                .collect(Collectors.toList());
    }
}
