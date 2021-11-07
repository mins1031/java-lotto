package exception.lotto;

public class OutsideInputNumException extends RuntimeException {
    private static final String WRONG_LOTTO_NUMBER_MESSAGE = "입력 번호는 1~45 사이의 숫자를 입력해야 합니다.";

    public OutsideInputNumException() {
        super(WRONG_LOTTO_NUMBER_MESSAGE);
    }
}
