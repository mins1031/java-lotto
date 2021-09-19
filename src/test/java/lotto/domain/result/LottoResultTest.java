package lotto.domain.result;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.TreeMap;

class LottoResultTest {
    @DisplayName("총상금 계산 테스트")
    @Test
    void calculateTotalReward() {
        //given
        TreeMap<Rank, Integer> rankIntegerTreeMap = new TreeMap<>(Comparator.comparing(Rank::getReward));
        rankIntegerTreeMap.put(Rank.FIFTH, 2);
        rankIntegerTreeMap.put(Rank.FOURTH, 1);

        LottoResult lottoResult = new LottoResult(rankIntegerTreeMap);

        //when
        long totalReward = lottoResult.calculateTotalReward();

        //then
        Assertions.assertThat(totalReward).isEqualTo(
                (Rank.FIFTH.getReward() * 2) + (Rank.FOURTH.getReward())
        );
    }

    @DisplayName("총상금 계산 테스트 - 당첨된 것이 없는 경우")
    @Test
    void name2() {
        //given
        TreeMap<Rank, Integer> rankIntegerTreeMap = new TreeMap<>(Comparator.comparing(Rank::getReward));

        LottoResult lottoResult = new LottoResult(rankIntegerTreeMap);

        //when
        long totalReward = lottoResult.calculateTotalReward();

        //then
        Assertions.assertThat(totalReward).isEqualTo(0);
    }

    @DisplayName("결과 toString 테스트")
    @Test
    void toStringTest() {
        //given
        TreeMap<Rank, Integer> rankIntegerTreeMap = new TreeMap<>(Comparator.comparing(Rank::getReward));
        rankIntegerTreeMap.put(Rank.FOURTH, 1);
        rankIntegerTreeMap.put(Rank.FIFTH, 2);

        LottoResult lottoResult = new LottoResult(rankIntegerTreeMap);

        //when
        String result = lottoResult.toString();

        //then
        Assertions.assertThat(result).isEqualTo(
                "3개 일치 (5000원)  - 2개\n" +
                "4개 일치 (50000원)  - 1개\n");
    }
}