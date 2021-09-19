package lotto.domain.lottogenerator;

import lotto.domain.gambler.Gambler;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNo;
import lotto.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGeneratorManual implements LottoGenerator {
    private static final String ERROR_MESSAGE_NOT_INTEGER = "숫자가 아닌 문자를 입력하였습니다.";

    @Override
    public List<Lotto> generate(Gambler gambler) {
        List<String> manualLottosNumber = gambler.getManualLottosNumber();
        return manualLottosNumber.stream()
                .map(StringUtils::splitByComma)
                .map(LottoGeneratorManual::toLottoNos)
                .map(Lotto::of)
                .collect(Collectors.toList());
    }

    private static List<LottoNo> toLottoNos(String[] winLotto) {
        try {
            return Arrays.stream(winLotto)
                    .map(Integer::parseInt)
                    .map(LottoNo::toLottoNo)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_INTEGER);
        }
    }
}
