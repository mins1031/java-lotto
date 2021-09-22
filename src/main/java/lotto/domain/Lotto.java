package lotto.domain;

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
        if (manualLotto < 0) {
            throw new IllegalArgumentException("로또의 개수는 음수가 될 수 없습니다.");
        }
        if (money.getMoney() < LOTTO_PRICE * manualLotto) {
            throw new IllegalArgumentException("로또 구매 가능 금액을 초과했습니다.");
        }
    }

    public static Lotto of (Money money, int manualLotto) {
        return new Lotto(money, manualLotto);
    }

    public void buyLottoManual (List<String> lineInputs) {
        if (manualLottoGames.size() == manualLotto) {
            System.out.println("수동 구매 가능 매수를 초과했습니다.");
            return;
        }

        for (String lineInput : lineInputs) {
            LottoGame lottoGame = LottoGame.parseLottoNumber(lineInput);
            manualLottoGames.add(lottoGame);
        }
    }

    public void buyLottoAutomatic () {
        if (autoLottoGames.size() == autoLotto) {
            System.out.println("자동 구매 가능 매수를 초과했습니다.");
            return;
        }

        for (int i = 0; i < autoLotto; ++i) {
            autoLottoGames.add(LottoGame.newInstance());
        }
    }

    public void print () {
        StringBuilder sb = new StringBuilder("수동으로 " + manualLotto + "장, 자동으로 " + autoLotto + "장을 구매했습니다.\n");

        for (LottoGame lottoGame : manualLottoGames) {
            sb.append(lottoGame);
        }

        for (LottoGame lottoGame : autoLottoGames) {
            sb.append(lottoGame);
        }

        System.out.println(sb);
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
}

