package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {
    private final List<LottoNumber> numbers;

    private LottoGame(List<LottoNumber> lottoNumbers) {
        validateLottoGame(lottoNumbers);

        numbers = new ArrayList<>();
        numbers.addAll(lottoNumbers);
    }

    private void validateLottoGame(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("6개의 번호가 있어야 합니다.");
        }
    }

    public static LottoGame from(List<LottoNumber> lottoNumbers) {
        return new LottoGame(lottoNumbers);
    }

    public static LottoGame newInstance() {
        Set<LottoNumber> tempSet = new TreeSet<>();

        while(tempSet.size() != 6) {
            int randomValue = new Random().nextInt(45);
            tempSet.add(LottoNumbers.getLottoNumbers().get(randomValue));
        }

        List<LottoNumber> distinctList = new ArrayList<>(tempSet);
        return new LottoGame(distinctList);
    }

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

    public int countMatch (LottoGame lottoGame) {
        int count = 0;

        for (LottoNumber number : lottoGame.getNumbers()) {
            if (this.numbers.contains(number)) {
                ++count;
            }
        }

        return count;
    }

    @Override
    public String toString() {
        return numbers.stream().map(Objects::toString).collect(Collectors.joining(", ", "[", "]\n"));
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
