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
        LottoNumber firstLottoNumber = new LottoNumber();
        LottoNumber secondLottoNumber = new LottoNumber();

        for (int i = 1; i< 7; i++){
            firstLottoNumber.add(i*2);
            secondLottoNumber.add(i*3);
        }
        lottoList.add(firstLottoNumber);
        lottoList.add(secondLottoNumber);

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
    void calculateBenefitRate(){
        //Given
        //When
        //Then
    }
}