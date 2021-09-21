package lotto.domain.lottos;

import lotto.domain.BuyMoney;
import lotto.scanner.InputScanner;

import static lotto.scanner.InputScanner.userNumberInput;

public class LottoInfo {

    private final int LOTTO_PRICE = 1000;
    private int totalLottoCount;
    private int manualLottoCount;
    private int autoLottoCount;

    public LottoInfo(BuyMoney buyMoney) {
        this.totalLottoCount = buyMoney.getPurchaseAmount() / LOTTO_PRICE ;
        //totalLottoCount가 buyMoney의 purchaseAmount값에 의존하고 있는 부분이 별로지만
        //buyMoney의 사용으로 값을 받고 값을 검증이 되었고 진행상황도 중단 시키기에 일관성도 유지된다
        //해당 LottoInfo클래스를 따로 뺸건 카운트 관련 값을 다루고 있는 클래스가 필요하기 떄문이다.
    }

    public void calculateInitValue(String message){

        int parseManualCount =
                InputScanner.userNumberInput(message);
        this.manualLottoCount = parseManualCount;
        validateLottoCount(this.totalLottoCount,this.manualLottoCount);
        this.autoLottoCount = this.totalLottoCount - this.manualLottoCount;
    }

    public void validateLottoCount(int totalLottoCount, int manualLottoCount) {
        if (totalLottoCount < manualLottoCount) {
            throw new IllegalArgumentException("최대 구매 갯수를 초과하여 입력하였습니다.");
        }
    }

    public int getLOTTO_PRICE() {
        return LOTTO_PRICE;
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
}
