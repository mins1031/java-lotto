package lotto.domain;

import lotto.stringUtils.StringUtils;
import lotto.validator.LottoValidator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    private Lotto (List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from (List<LottoNumber> lottoNumbers) {
        LottoValidator.validate(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public static Lotto parseLottoNumber(String lottoNumberInput) {
        return from(Stream.of(StringUtils.splitByComma(lottoNumberInput))
                .map(Integer::parseInt)
                .distinct()
                .sorted()
                .map(LottoNumbers::getNumber)
                .collect(Collectors.toList()));
    }

    public static Lotto makeAutoLotto() {
        Set<LottoNumber> tempSet = new TreeSet<>();

        while(tempSet.size() != 6) {
            tempSet.add(LottoNumbers.getRandomNumber());
        }

        List<LottoNumber> distinctList = new ArrayList<>(tempSet);
        return from(distinctList);
    }

    public boolean contains (LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.stream().map(Objects::toString).collect(Collectors.joining(", ", "[", "]\n"));
    }
}
