package lotto.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoNoTest {

    @DisplayName("lotto box 초기화 테스트")
    @Test
    void init() {
        Map<Integer, LottoNo> lottoNoBox = LottoNo.lottoNoBox;

        Assertions.assertThat(lottoNoBox.size()).isEqualTo(45);
        Assertions.assertThat(lottoNoBox.get(1)).isEqualTo(LottoNo.toLottoNo(1));
        Assertions.assertThat(
                lottoNoBox.keySet()
                        .stream()
                        .min(Comparator.naturalOrder())
                        .get())
                .isEqualTo(1);
        Assertions.assertThat(
                lottoNoBox.keySet()
                        .stream()
                        .max(Comparator.naturalOrder())
                        .get())
                .isEqualTo(45);
    }
}