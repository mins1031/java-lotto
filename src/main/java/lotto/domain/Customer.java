package lotto.domain;

import lotto.validator.CustomerValidator;

import java.util.List;

public class Customer {
    private Money money;
    private List<String> lottoNumbers;

    private Customer(Money money, List<String> lottoNumbers) {
        this.money = money;
        this.lottoNumbers = lottoNumbers;
    }

    public static Customer of(Money money, List<String> lottoNumbers) {
        CustomerValidator.validate(money, lottoNumbers);
        return new Customer(money, lottoNumbers);
    }

    public Money getMoney() {
        return money;
    }

    public List<String> getLottoNumbers() {
        return lottoNumbers;
    }
}
