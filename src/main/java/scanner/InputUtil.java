package scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static String inputTotalBuyMoney() {
        System.out.println(OutputUtil.TOTALMONEY_MESSAGE);
        return scanner.next();
    }

    public static String inputManualLottoCount() {
        System.out.println(OutputUtil.MANUALLOTTOCOUNT_MESSAGE);
        return scanner.next();
    }

    public static List<String> inputManualLottoNums(int manualLottoCount) {
        System.out.println(OutputUtil.MANUALLOTTONUMS_MESSAGE);
        scanner.nextLine();
        List<String> rawManualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            rawManualLottos.add(scanner.nextLine());
        }
        return rawManualLottos;
    }

    public static String inputWinNums() {
        System.out.println(OutputUtil.WINNUMBERS_MESSAGE);
        return scanner.nextLine();
    }

    public static int inputBonusBall() {
        System.out.println(OutputUtil.BONUSBALL_MESSAGE);
        return scanner.nextInt();
    }


}
