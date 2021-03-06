package domain.lotto;

class LottoFrontTest {

//    @Test
//    @DisplayName("수동 로또를 문자열 형태로 입력받아 진짜 리스트로 만들기")
//    void saveManualLottoNumsTest() {
//        //given
//        String raw1 = "8, 21, 23, 41, 42, 43";
//        String raw2 = "3, 5, 11, 16, 32, 38";
//        String raw3 = "7, 11, 16, 35, 36, 44";
//
//        List<String> rawManualLottos = new ArrayList<>();
//        rawManualLottos.add(raw1);
//        rawManualLottos.add(raw2);
//        rawManualLottos.add(raw3);
//        Buyer buyer = new Buyer(14000);
//        buyer.defineLottoCounts(3);
//        //when
//        LottoManualGenerator lottoManualGenerator = new LottoManualGenerator();
//        List<Lotto> manualLottos = lottoManualGenerator.generate(buyer);
//
//        //then
//        Assertions.assertThat(manualLottos).hasSize(3);
//        Assertions.assertThat(manualLottos.get(0).getLotto().get(0).getNum()).isEqualTo(8);
//        Assertions.assertThat(manualLottos.get(0).getLotto().get(1).getNum()).isEqualTo(21);
//        Assertions.assertThat(manualLottos.get(0).getLotto().get(2).getNum()).isEqualTo(23);
//        Assertions.assertThat(manualLottos.get(0).getLotto().get(3).getNum()).isEqualTo(41);
//        Assertions.assertThat(manualLottos.get(0).getLotto().get(4).getNum()).isEqualTo(42);
//        Assertions.assertThat(manualLottos.get(0).getLotto().get(5).getNum()).isEqualTo(43);
//        Assertions.assertThat(manualLottos.get(1).getLotto().get(0).getNum()).isEqualTo(3);
//        Assertions.assertThat(manualLottos.get(1).getLotto().get(1).getNum()).isEqualTo(5);
//        Assertions.assertThat(manualLottos.get(1).getLotto().get(2).getNum()).isEqualTo(11);
//        Assertions.assertThat(manualLottos.get(1).getLotto().get(3).getNum()).isEqualTo(16);
//        Assertions.assertThat(manualLottos.get(1).getLotto().get(4).getNum()).isEqualTo(32);
//        Assertions.assertThat(manualLottos.get(1).getLotto().get(5).getNum()).isEqualTo(38);
//        Assertions.assertThat(manualLottos.get(2).getLotto().get(0).getNum()).isEqualTo(7);
//        Assertions.assertThat(manualLottos.get(2).getLotto().get(1).getNum()).isEqualTo(11);
//        Assertions.assertThat(manualLottos.get(2).getLotto().get(2).getNum()).isEqualTo(16);
//        Assertions.assertThat(manualLottos.get(2).getLotto().get(3).getNum()).isEqualTo(35);
//        Assertions.assertThat(manualLottos.get(2).getLotto().get(4).getNum()).isEqualTo(36);
//        Assertions.assertThat(manualLottos.get(2).getLotto().get(5).getNum()).isEqualTo(44);
//    }
//
//    @Test
//    @DisplayName("[예외]수동 로또 수를 5개 준 경우")
//    void saveManualLottoNumsTest2() {
//        //given
//        String raw1 = "8, 21, 23, 41, 42";
//        String raw2 = "3, 5, 11, 16, 32, 38";
//        String raw3 = "7, 11, 16, 35, 36, 44";
//
//        List<String> rawManualLottos = new ArrayList<>();
//        rawManualLottos.add(raw1);
//        rawManualLottos.add(raw2);
//        rawManualLottos.add(raw3);
//        //when
//        LottoFront lottoFront = new LottoFront();
//
//        //then
//        Assertions.assertThatThrownBy(() ->
//                lottoFront.saveManualLottoNums(rawManualLottos))
//                .isInstanceOf(InputLottoCountException.class);
//    }
//
//    @Test
//    @DisplayName("[예외]수동 로또 수를 7개 준 경우")
//    void saveManualLottoNumsTest3() {
//        //given
//        String raw1 = "8, 21, 23, 41, 42, 43, 45";
//        String raw2 = "3, 5, 11, 16, 32, 38";
//        String raw3 = "7, 11, 16, 35, 36, 44";
//
//        List<String> rawManualLottos = new ArrayList<>();
//        rawManualLottos.add(raw1);
//        rawManualLottos.add(raw2);
//        rawManualLottos.add(raw3);
//        //when
//        LottoFront lottoFront = new LottoFront();
//
//        //then
//        Assertions.assertThatThrownBy(() ->
//                lottoFront.saveManualLottoNums(rawManualLottos))
//                .isInstanceOf(InputLottoCountException.class);
//    }
//
//    @Test
//    void autoGenerateLottoTest() {
//        //given
//        int autoLottoCount = 5;
//        //when
//        LottoFront lottoFront = new LottoFront();
//        lottoFront.generateAutoLottos(autoLottoCount);
//        //then
//        Assertions.assertThat(lottoFront.getLottos()).hasSize(5);
//        Assertions.assertThat(LottoNums.getLottoNumList())
//                .contains(lottoFront.getLottos().get(0).getLotto().get(0));
//    }
//
//    @Test
//    void toLottoNumTest() {
//        //given
//        String rawNums = "31, 28, 5, 20, 45, 1";
//        LottoFront lottoFront = new LottoFront();
//        //when
//        List<LottoNum> lottoNums = lottoFront.toLottoNum(rawNums);
//        //then
//        Assertions.assertThat(lottoNums).hasSize(6);
//        Assertions.assertThat(lottoNums.get(0).getNum()).isEqualTo(31);
//        Assertions.assertThat(lottoNums.get(1).getNum()).isEqualTo(28);
//        Assertions.assertThat(lottoNums.get(2).getNum()).isEqualTo(5);
//        Assertions.assertThat(lottoNums.get(3).getNum()).isEqualTo(20);
//        Assertions.assertThat(lottoNums.get(4).getNum()).isEqualTo(45);
//        Assertions.assertThat(lottoNums.get(5).getNum()).isEqualTo(1);
//    }
}