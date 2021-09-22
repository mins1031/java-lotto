package lotto.util;

import lotto.domain.lottos.LottoGame;
import lotto.domain.lottos.LottoNumber;
import lotto.domain.lottos.LottoNumbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoParser {
    public static LottoGame parseLottoNumber (String stringInput) {
        List<LottoNumber> numbers = Stream.of(stringInput.split("\\s*,\\s*"))
                .map(Integer::parseInt)
                .distinct()
                .sorted()
                .filter(x -> (x > 0 && x < 46))
                .map(x -> LottoNumbers.getLottoNumbers().get(x - 1))
                .collect(Collectors.toList());

        return LottoGame.from(numbers);
    }
}
