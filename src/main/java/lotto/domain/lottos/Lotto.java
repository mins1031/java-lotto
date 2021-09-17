package lotto.domain.lottos;

import lotto.scanner.InputScanner;

import java.util.*;

public class Lotto {

    private static List<LottoNo> lottoNumberList = LottoNumbers.getInstance();
    private static List<LottoGame> lottoGames = new ArrayList<>();

    public Lotto() {
    }

    public static Lotto createManualLotto(String message, int manualCount) {

        System.out.println(message);

        List<LottoGame> inputLottoNumbers = InputScanner.userLottoInput(manualCount);

        lottoGames.addAll(inputLottoNumbers);

        return new Lotto();
    }

    public static List<LottoGame> createAutoLotto(int autoLottoCount) {
        for (int i = 0; i<autoLottoCount; i++) {
            lottoGames.add(getRandomNumList());
        }

        return lottoGames;
    }

    public static LottoGame getRandomNumList() {
        Set<LottoNo> tempSet = new TreeSet<>();

        while(tempSet.size() != 6) {
            int randomValue = new Random().nextInt(45);
            tempSet.add(lottoNumberList.get(randomValue));
        }
        List<LottoNo> nonDupList = new ArrayList<>(tempSet);
        LottoGame lottoGame = new LottoGame();
        lottoGame.addAll(nonDupList);

        return lottoGame;
    }

    public void print(){
        for (LottoGame printLotto : lottoGames) {
            System.out.println(printLotto.toString());
        }
    }

    public List<LottoGame> getLottoGames() {
        return lottoGames;
    }
}

