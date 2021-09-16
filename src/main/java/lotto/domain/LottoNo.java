package lotto.domain;

public class LottoNo {
    private final int number;

    private LottoNo(int number) {
        this.number = number;
    }

    public static LottoNo createLottoNumber (String number) {
        int lottoNo = Integer.parseInt(number);
        lottoNumberValidate(lottoNo);
        return new LottoNo(lottoNo);
    }

    private static void lottoNumberValidate (int lottoNo) {
        if (lottoNo < 1 || lottoNo > 45) {
            throw new IllegalArgumentException("1 ~ 45 이내의 숫자를 입력해야 합니다.");
        }
    }
}
