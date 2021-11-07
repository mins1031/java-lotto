package exception.lotto;

public class OutRangeInputManualLottoCount extends RuntimeException {
    private static final String OUT_RANGE_MANUAL_LOTTO_NUM_MESSAGE = "수동로또는 정수이고 전체 갯수 보다 작아야 합니다.";

    public OutRangeInputManualLottoCount() {
        super(OUT_RANGE_MANUAL_LOTTO_NUM_MESSAGE);
    }
}
