package lotto.domain.lottos;

import lotto.scanner.InputScanner;

import java.util.*;

public class Lotto {

    //싱글톤화한 LottoNo들의 집합인 LotoNumers의 List
    private List<LottoNo> lottoNumberList = LottoNumbers.getInstance();
    //사용자의 로또 결과 리스트
    private List<LottoGame> lottoGames = new ArrayList<>();

    public Lotto() {
    }

    public void createManualLotto(String message, int manualCount) {

        List<LottoGame> inputLottoNumbers = InputScanner.userLottoInput(manualCount);

        lottoGames.addAll(inputLottoNumbers);
    }

    public void createAutoLotto(int autoLottoCount) {
        for (int i = 0; i<autoLottoCount; i++) {
            lottoGames.add(getRandomNumList());
        }
    }

    public LottoGame getRandomNumList() {
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

