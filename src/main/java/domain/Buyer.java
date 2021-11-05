package domain;

import domain.lotto.Lotto;
import domain.lotto.LottoFront;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private int totalBuyMoney;
    private int totalLottoCount;
    private int manualLottoCount;
    private int autoLottoCount;

    private List<Lotto> buyLottos = new ArrayList<>();

    public Buyer(int totalBuyMoney) {
        this.totalBuyMoney = totalBuyMoney;
        this.totalLottoCount = totalBuyMoney / LottoFront.LOTTO_PRICE;
    }

    public void defineLottoCounts(int manualLottoCount) {
        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = totalLottoCount - manualLottoCount;
    }

    public void addAll(List<Lotto> lottos) {
        buyLottos.addAll(lottos);
    }

    public int getTotalBuyMoney() {
        return totalBuyMoney;
    }

    public int getTotalLottoCount() {
        return totalLottoCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }

    public List<Lotto> getBuyLottos() {
        return buyLottos;
    }
}
