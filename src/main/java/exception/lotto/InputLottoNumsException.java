package exception.lotto;

public class InputLottoNumsException extends RuntimeException {
    private static final String WRONG_LOTTONUMS_MESSAGE = "로또번호는 중복 없이 6개여야 합니다";

    public InputLottoNumsException() {
        super(WRONG_LOTTONUMS_MESSAGE);
    }
}
