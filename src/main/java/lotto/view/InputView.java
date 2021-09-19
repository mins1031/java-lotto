package lotto.view;

import lotto.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final String MESSAGE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_INPUT_BONUS = "보너스 볼을 입력해 주세요.";
    private static final String MESSAGE_INPUT_WIN_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_INPUT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또의 개수를 입력해 주세요.";
    private static final String MESSAGE_INPUT_MANUAL_LOTTO_NUMBER = "수동으로 구매할 로또 번호들을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println(MESSAGE_INPUT_MONEY);
        return StringUtils.ToInt(scanner.next());
    }

    public static int inputManualLottoCount() {
        System.out.println(MESSAGE_INPUT_MANUAL_LOTTO_COUNT);
        return StringUtils.ToInt(scanner.next());
    }

    public static String inputBonusBall() {
        System.out.println(MESSAGE_INPUT_BONUS);
        return scanner.next();
    }

    public static String inputWinNumber() {
        System.out.println(MESSAGE_INPUT_WIN_NUMBER);
        return scanner.next();
    }

    public static List<String> inputManualLottoNumbers(int manualLottoCount) {
        if (manualLottoCount > 0) {
            System.out.println(MESSAGE_INPUT_MANUAL_LOTTO_NUMBER);
        }
        return IntStream.range(0, manualLottoCount)
                .mapToObj(count -> scanner.next())
                .collect(Collectors.toList());
    }
}
