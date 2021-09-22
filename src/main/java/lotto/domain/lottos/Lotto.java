package lotto.domain.lottos;

import lotto.domain.Money;
import lotto.scanner.InputScanner;

import java.util.*;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;

    private final int manualLotto;
    private final int autoLotto;
    private final Money money;
    private final List<LottoGame> manualLottoGames;
    private final List<LottoGame> autoLottoGames;

    private Lotto(Money money, int manualLotto) {
        validateLotto(money, manualLotto);

        this.manualLotto = manualLotto;
        this.autoLotto = (money.getMoney() / LOTTO_PRICE) - manualLotto;
        this.money = money;
        this.manualLottoGames = new ArrayList<>();
        this.autoLottoGames = new ArrayList<>();
    }

    private void validateLotto(Money money, int manualLotto) {
        if (money.getMoney() < LOTTO_PRICE * manualLotto) {
            throw new IllegalArgumentException("수동 로또의 갯수가 구매 금액을 초과했습니다.");
        }
    }

    public static Lotto of (Money money, int manualLotto) {
        return new Lotto(money, manualLotto);
    }

    public int getManualLotto() {
        return manualLotto;
    }

    public int getAutoLotto() {
        return autoLotto;
    }

    public Money getMoney() {
        return money;
    }

    public List<LottoGame> getManualLottoGames() {
        return manualLottoGames;
    }

    public List<LottoGame> getAutoLottoGames() {
        return autoLottoGames;
    }
//
//    private
//
//    private List<LottoNumber> lottoNumberList = LottoNumbers.getLottoNumbers();
//    private List<LottoGame> lottoGames = new ArrayList<>();
//
//    public Lotto() {
//    }
//
//    public void print(){
//        for (LottoGame lottoGame : lottoGames) {
//            System.out.println(lottoGame);
//        }
//    }
}

