package lotto;

import lotto.domain.LottoCalcurator;
import lotto.domain.WinInfo;
import lotto.domain.WinResult;
import lotto.domain.lottos.Lotto;
import lotto.domain.lottos.LottoGame;
import lotto.domain.lottos.LottoNo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoCalcuratorTest {

    public List<LottoGame> getnerateLottoGameList(){
        List<LottoGame> gameList = new ArrayList<>();

        int [] data1 = {2,4,5,8,10,14};
        int [] data2 = {2,5,7,10,14,16};

        List<LottoNo> collect1 =
                Arrays.stream(data1)
                .mapToObj(x -> new LottoNo(x))
                .collect(Collectors.toList());
        List<LottoNo> collect2 =
                Arrays.stream(data2)
                .mapToObj(x -> new LottoNo(x))
                .collect(Collectors.toList());

        LottoGame game1 = new LottoGame();
        LottoGame game2 = new LottoGame();
        game1.addAll(collect1);
        game2.addAll(collect2);

        gameList.add(game1);
        gameList.add(game2);

        return gameList;

    }

    @Test
    void calculateStatisticTest(){
        //Given
        Lotto lotto = new Lotto();
        List<LottoGame> lottoGames = getnerateLottoGameList();
        lottoGames.stream().forEach(System.out::println);
        lotto.setLottoGames(lottoGames);

        int [] tempWinNums = {2,3,5,10,14,16};

        List<LottoNo> winNums = Arrays.stream(tempWinNums)
                .mapToObj(x -> new LottoNo(x))
                .collect(Collectors.toList());

        winNums.stream().forEach(System.out::println);

        System.out.println(winNums.get(0).getClass());

        if (winNums.contains(lottoGames.get(0).getNumbers().get(0)))
            System.out.println("y!!!!");

        LottoNo bonusBall = new LottoNo(7);

        LottoGame lottoGame = new LottoGame();
        lottoGame.addAll(winNums);

        WinInfo winInfo = new WinInfo();
        winInfo.setWinNumbers(lottoGame);
        winInfo.setBonusBall(bonusBall);

        //When
        WinResult winResult = LottoCalcurator.calculateStatistic(winInfo,lotto);

        //Then
        Assertions.assertThat(winResult.getThreeMatchCount()).isEqualTo(0);
        Assertions.assertThat(winResult.getFourMatchCount()).isEqualTo(1);
        Assertions.assertThat(winResult.getFiveMatchCount()).isEqualTo(0);
        Assertions.assertThat(winResult.getFiveAndBonusMatchCount()).isEqualTo(1);
        Assertions.assertThat(winResult.getSixMatchCount()).isEqualTo(0);

    }

}