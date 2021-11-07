package domain;

import domain.lotto.Lotto;
import domain.money.BuyMoney;
import exception.lotto.InputLottoTypeException;
import exception.lotto.OutRangeInputManualLottoCount;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private BuyMoney buyMoney;
    private int totalLottoCount;
    private int manualLottoCount;
    private int autoLottoCount;

    private List<Lotto> buyLottos = new ArrayList<>();

    public Buyer(BuyMoney buyMoney) {
        this.buyMoney = buyMoney;
        this.totalLottoCount = buyMoney.getTotalBuyMoney() / Lotto.LOTTO_PRICE;
    }

    public void defineAllLottoCountTypes(String rawManualLottoCount) {
        int realManualLottoCount = toIntegerOfManualLottoCount(rawManualLottoCount);
        this.manualLottoCount = realManualLottoCount;
        this.autoLottoCount = totalLottoCount - realManualLottoCount;
    }

    private int toIntegerOfManualLottoCount(String rawManualLottoCount) {
        try {
            int manualLottoCount = Integer.parseInt(rawManualLottoCount);
            validateManualLottoCount(manualLottoCount, totalLottoCount);
            return manualLottoCount;
        } catch (NumberFormatException e) {
            throw new InputLottoTypeException();
        }
    }

    private void validateManualLottoCount(int manualLottoCount, int totalLottoCount) {
        if (manualLottoCount <= 0 || manualLottoCount > totalLottoCount) {
            int i = 0;
            throw new OutRangeInputManualLottoCount();
        }
    }


    public void addAll(List<Lotto> lottos) {
        buyLottos.addAll(lottos);
    }

    public BuyMoney getBuyMoney() {
        return buyMoney;
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
