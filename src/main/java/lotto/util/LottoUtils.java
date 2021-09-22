package lotto.util;

import lotto.domain.lottos.LottoGame;

import java.util.ArrayList;
import java.util.List;

public class LottoUtils {
    public static List<LottoGame> createManualLottoList(List<String> lineInputs) {
        List<LottoGame> lottoGames = new ArrayList<>();

        for (String lineInput : lineInputs) {
            LottoGame lottoGame = LottoParser.parseLottoNumber(lineInput);
            lottoGames.add(lottoGame);
        }

        return lottoGames;
    }

    public static List<LottoGame> createAutoLottoList(int iterator) {
        List<LottoGame> lottoGames = new ArrayList<>();

        for (int i = 0; i < iterator; ++i) {
            lottoGames.add(LottoGame.newInstance());
        }

        return lottoGames;
    }
}
