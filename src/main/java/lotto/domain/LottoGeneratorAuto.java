package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGeneratorAuto implements LottoGenerator {

    private List<Lotto> lottos;

    private LottoGeneratorAuto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoGeneratorAuto(Customer customer) {
        generate(customer);
    }

    @Override
    public void generate(Customer customer) {
        int range = customer.getMoney().getMoney() / Lotto.LOTTO_PRICE - customer.getLottoNumbers().size();
        this.lottos = IntStream.range(0, range).mapToObj(x -> Lotto.makeAutoLotto()).collect(Collectors.toList());
    }

    @Override
    public String getType() {
        return "자동";
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
