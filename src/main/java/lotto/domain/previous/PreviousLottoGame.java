package lotto.domain.previous;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PreviousLottoGame {
    private final List<LottoNumber> numbers;

    private PreviousLottoGame(List<LottoNumber> lottoNumbers) {
        validateLottoGame(lottoNumbers);

        numbers = new ArrayList<>();
        numbers.addAll(lottoNumbers);
    }

    private void validateLottoGame(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("6개의 번호가 있어야 합니다.");
        }
    }

    public static PreviousLottoGame from(List<LottoNumber> lottoNumbers) {
        return new PreviousLottoGame(lottoNumbers);
    }

    public static PreviousLottoGame newInstance() {
        Set<LottoNumber> tempSet = new TreeSet<>();

        while(tempSet.size() != 6) {
            int randomValue = new Random().nextInt(45) + 1;
            tempSet.add(LottoNumbers.getNumber(randomValue));
        }

        List<LottoNumber> distinctList = new ArrayList<>(tempSet);
        return new PreviousLottoGame(distinctList);
    }

    public static PreviousLottoGame parseLottoNumber(String stringInput) {
        List<LottoNumber> numbers = Stream.of(stringInput.split("\\s*,\\s*"))
                .map(Integer::parseInt)
                .distinct()
                .sorted()
                .filter(x -> (x > 0 && x < 46))
                .map(LottoNumbers::getNumber)
                .collect(Collectors.toList());

        return PreviousLottoGame.from(numbers);
    }

    public int countMatch(PreviousLottoGame lottoGame) {
        return Long.valueOf(lottoGame.getNumbers().stream().filter(numbers::contains).count()).intValue();
    }

    @Override
    public String toString() {
        return numbers.stream().map(Objects::toString).collect(Collectors.joining(", ", "[", "]\n"));
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
