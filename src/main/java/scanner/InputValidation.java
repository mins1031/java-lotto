package scanner;

import exception.TotalMoneyException;

public class InputValidation {

    public static void validateTotalMoney(int totalMoney) {
        if (totalMoney <= 0) {
            throw new TotalMoneyException("구매금액은 0을 넘어야 합니다.");
        }
    }

    public static void validateManualLottoCount(int manualLottoCount, int totalLottoCount) {
        if (manualLottoCount < 0 || manualLottoCount > totalLottoCount) {
            throw new TotalMoneyException("구매금액은 0을 넘어야 합니다.");
        }
    }
}
