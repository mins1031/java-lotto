import lotto.domain.BuyMoney;
import lotto.exception.ExceptionHandler;
import lotto.scanner.InputScanner;

import java.util.Scanner;

public class LottoMain {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BuyMoney totalAmount = BuyMoney.configPurchaseAmount("구매금액을 입력해 주세요.");
        int totalLottoCount = totalAmount.getPurchaseAmount() / LOTTO_PRICE;

        int manualLottoCount = InputScanner.userNumberInput("수동으로 구매할 로또 수를 입력해 주세요.");
        ExceptionHandler.validateLottoCount(totalLottoCount, manualLottoCount);

        /*String[] manualNumList = InputScanner.userLottoInput("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            String manualNum = scan.nextLine();
            Lotto tempLottoNumber = new Lotto();
            tempLottoNumber.addAll(LottoUtil.lottoNumberParser(manualNum));
            lottoList.add(tempLottoNumber);
        }*/
//
//        int autoLottoCount = totalLottoCount - manualLottoCount;
//
//        // merge auto
//        lottoList.addAll(LottoUtil.autoNumCreate(autoLottoCount));
//
//        //print
//        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "개를 구매했습니다");
//        for (Lotto lottoNumber : lottoList) {
//            System.out.println(lottoNumber);
//        }
//
//        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
//        String inputWinNum = scan.nextLine();
//        List<Integer> winNumbers = LottoUtil.lottoNumberParser(inputWinNum);
//
//        System.out.println("보너스 볼을 입력해 주세요.");
//        int bonusBall = scan.nextInt();
//
//        LottoResult lottoResult = new LottoResult(winNumbers, bonusBall);
//        lottoResult.winResult(lottoList);
//        lottoResult.calculateBenefitRate(totalAmount);
//
//        System.out.println("");
//        System.out.println("당첨 통계");
//        System.out.println("---------");
//        System.out.println(lottoResult.toString());

        scan.close();
    }
}
