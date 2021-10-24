package scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputUtil {

    private static Scanner scanner = new Scanner(System.in);
    private static final String TOTALMONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String MANUALLOTTOCOUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUALLOTTONUMS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    public static int inputTotalBuyMoney() {
        System.out.println(TOTALMONEY_MESSAGE);
        int totalMoney = Integer.parseInt(scanner.next());
        InputValidation.validateTotalMoney(totalMoney);
        return totalMoney;
    }

    public static int inputManualLottoCount(int totalLottoCount) {
        System.out.println(MANUALLOTTOCOUNT_MESSAGE);
        int manualLottoCount = Integer.parseInt(scanner.next());
        InputValidation.validateManualLottoCount(manualLottoCount, totalLottoCount);
        return manualLottoCount;
    }

    public static List<String> inputManualLottoNums(int manualLottoCount) {
        System.out.println(MANUALLOTTONUMS_MESSAGE);
        scanner.nextLine();
        List<String> rawManualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            rawManualLottos.add(scanner.nextLine());
        }
        return rawManualLottos;
    }

}
