package exception.lotto;

public class WrongInputNumsException extends RuntimeException {
    private static final String WRONG_LOTTONUMS_MESSAGE = "입력번호는 중복 없이 6개여야 합니다";

    public WrongInputNumsException() {
        super(WRONG_LOTTONUMS_MESSAGE);
    }
}
