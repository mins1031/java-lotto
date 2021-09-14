package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {



    @BeforeEach
    void before(){

    }

    @Test
    void winResultTest(){
        //Given
        List<LottoNumber> lottoList = new ArrayList<>();
        LottoNumber lottoNumber1 = new LottoNumber();
        LottoNumber lottoNumber2 = new LottoNumber();

        for (int i = 1; i< 7; i++){
            lottoNumber1.add(i*2);
            lottoNumber2.add(i*3);
        }
        lottoList.add(lottoNumber1);
        lottoList.add(lottoNumber2);

        int [] winNumbers = {2, 3, 4, 6, 8, 9};
        int bonusBall = 7;

        LottoResult lottoResult = new LottoResult(winNumbers,bonusBall);
        //When
        lottoResult.winResult(lottoList);
        //Then
        Assertions.assertThat(lottoResult.getMatchThree()).isEqualTo(1);
        Assertions.assertThat(lottoResult.getMatchFour()).isEqualTo(1);

    }

    @Test
    void checkMatchCount(){
        //Given
        //When
        //Then
    }

    @Test
    void calculateBenefitRate(){
        //Given
        LottoResult testLotto = new LottoResult();

        int totalAmount = 100;
        //When
        //Then
    }
}