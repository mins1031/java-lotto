package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoGeneratorManual implements LottoGenerator {

    private List<Lotto> lottos;

    private LottoGeneratorManual(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoGeneratorManual(Customer customer) {
        generate(customer);
    }

    @Override
    public void generate(Customer customer) {
        this.lottos = customer.getLottoNumbers().stream().map(Lotto::parseLottoNumber).collect(Collectors.toList());
    }

    @Override
    public String getType() {
        return "수동";
    }

    @Override
    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return lottos.stream().map(Objects::toString).collect(Collectors.joining());
    }
}
