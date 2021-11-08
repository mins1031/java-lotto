package lotto.domain.previous;

import lotto.domain.Money;

import java.util.*;

public class PreviousLotto {
    private static final int LOTTO_PRICE = 1000;

    private final int manualLotto;
    private final int autoLotto;
    private final Money money;
    private final List<PreviousLottoGame> manualLottoGames;
    private final List<PreviousLottoGame> autoLottoGames;

    private PreviousLotto(Money money, int manualLotto) {
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

    public static PreviousLotto of(Money money, int manualLotto) {
        return new PreviousLotto(money, manualLotto);
    }

    public void buyLottoManual (List<String> lineInputs) {
        if (manualLottoGames.size() == manualLotto) {
            System.out.println("수동 구매 가능 매수를 초과했습니다.");
            return;
        }

        for (String lineInput : lineInputs) {
            PreviousLottoGame lottoGame = PreviousLottoGame.parseLottoNumber(lineInput);
            manualLottoGames.add(lottoGame);
        }
    }

    public void buyLottoAutomatic() {
        if (autoLottoGames.size() == autoLotto) {
            System.out.println("자동 구매 가능 매수를 초과했습니다.");
            return;
        }

        for (int i = 0; i < autoLotto; ++i) {
            autoLottoGames.add(PreviousLottoGame.newInstance());
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder("수동으로 " + manualLotto + "장, 자동으로 " + autoLotto + "장을 구매했습니다.\n");

        for (PreviousLottoGame lottoGame : manualLottoGames) {
            sb.append(lottoGame);
        }

        for (PreviousLottoGame lottoGame : autoLottoGames) {
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

    public List<PreviousLottoGame> getManualLottoGames() {
        return manualLottoGames;
    }

    public List<PreviousLottoGame> getAutoLottoGames() {
        return autoLottoGames;
    }
}

