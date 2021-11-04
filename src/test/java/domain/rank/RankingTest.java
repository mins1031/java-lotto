package domain.rank;

import domain.lotto.Lotto;
import domain.lotto.LottoNum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class RankingTest {

    @Test
    void name() {
        //given
        int[] rawArr = {5, 9, 19, 23, 33, 39};
        List<LottoNum> lottoNums = IntStream.range(0, 6).mapToObj(idx -> LottoNum.of(rawArr[idx])).collect(Collectors.toList());
        Lotto lotto = new Lotto();
        lotto.addAll(lottoNums);

        int bonusBall = 39;
        int[] rawWinNums = {5, 9, 19, 23, 33, 41};
        List<LottoNum> winNums = IntStream.range(0, 6).mapToObj(idx -> LottoNum.of(rawWinNums[idx])).collect(Collectors.toList());
        //when
        Ranking ranking = Ranking.compareMatchCountAndBonusBall(winNums, bonusBall, lotto);
        //then
        Assertions.assertThat(ranking).isEqualTo(Ranking.SECOND);
    }
}