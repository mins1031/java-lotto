package lotto.domain;

public class WinResult {

    /**
     * Map을 쓰는게 좋을까 배열의 인덱스로 하는게 좋을까 이방식이 좋을까
     * 배열의 인덱스는 가독성, 일관성(3번쨰 인덱스 부터 적용해서 인덱스의 수로 매치 갯수를 파악하는 방식은
     * 앞의 0,1,2번째 인덱스를 제외하고 하기에 일관성이 업고, 첫번째 부터 한다고 해도 3번째 수를 배열에 담는게 효율적이어 보이지는 않는다)이 현저히 부족한듯하다
     * 그럼 Map은 사실 잘 모르겠긴 한데 굳이 Map을 사용할 필요는 없어보인다
     * 1) Map은 이름이 있는 여러개의 데이터를 저장할때 유용할듯하고 이렇게 적은
     * 데이터는 변수로 해도 무방할듯.ㅁ
     * */
    private int threeMatchCount = 0;
    private int fourMatchCount = 0;
    private int fiveMatchCount = 0;
    private int fiveAndBonusMatchCount = 0;
    private int sixMatchCount = 0;

    public void distributeMatchCnt(int matchCnt, int bonusCnt){
        if (matchCnt == 3){
            this.threeMatchCount++;
        } else if (matchCnt == 4){
            this.fourMatchCount++;
        } else if (matchCnt == 5){
            if (bonusCnt == 1){
                this.fiveAndBonusMatchCount++;
            } else {
                this.fiveMatchCount++;
            }
        } else if (matchCnt == 6){
            this.sixMatchCount++;
        }
    }

    public int getThreeMatchCount() {
        return threeMatchCount;
    }

    public int getFourMatchCount() {
        return fourMatchCount;
    }

    public int getFiveMatchCount() {
        return fiveMatchCount;
    }

    public int getFiveAndBonusMatchCount() {
        return fiveAndBonusMatchCount;
    }

    public int getSixMatchCount() {
        return sixMatchCount;
    }

}
