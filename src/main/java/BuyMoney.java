public class BuyMoney {

    private int purchaseAmount;

    private BuyMoney(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public static BuyMoney configPurchaseAmount(String message) {

        int convertPurchaseAmount = InputScanner.userNumberInput(message);

        validatePurchaseAmount(convertPurchaseAmount);

        return new BuyMoney(convertPurchaseAmount);
    }

    public static void validatePurchaseAmount(int inputPurchaseAmount){
        if (inputPurchaseAmount <= 0){
            throw new IllegalArgumentException("구매금액은 0보다 커야합니다.");
        }
    }
}
