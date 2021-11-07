package exception.win;

public class DuplicateBonusBallWithWinNumbers extends RuntimeException {
    private static final String DUPLCATE_BONUSBALL_MESSAGE = "당첨번호화 보너스볼은 중복될 수 없습니다.";

    public DuplicateBonusBallWithWinNumbers() {
        super(DUPLCATE_BONUSBALL_MESSAGE);
    }
}
