# java-lotto

```
실행 결과
구입금액을 입력해 주세요.
14000

수동으로 구매할 로또 수를 입력해 주세요.
3

수동으로 구매할 번호를 입력해 주세요.
8, 21, 23, 41, 42, 43
3, 5, 11, 16, 32, 38
7, 11, 16, 35, 36, 44

수동으로 3장, 자동으로 11개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

보너스 볼을 입력해 주세요.
7

36

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

8, 21, 23, 41, 42, 43
7, 11, 16, 35, 37, 45
7, 11, 16, 35, 36, 41

7, 11, 16, 35, 37, 41

36

- 추가 or 리팩토링 되야 할것
  - 수익률 소수점
  - lottoFront, Market 네이밍 고찰
  - 로또 생성방식 인터페이스 구현화
  - buyer 
  - 보너스볼 입력시 당첨번호와 겹치치 않는 수를 입력해야 하는 로직
  - 당첨번호 입력시 6개인지 아닌지
  - 리팩토링  
    
- TDD 적용해본 결과
  1) 우선 목표가 정해져 있어 간결한 구현을 할 수 있다
  2) 작은 단위부터 차근차근 나가서 생각보다 복잡도가 해소되었다.

## 기능목록
0) 로또 1매의 가격은 1000원
  * static 상수로 선언 : static final int LOTTO_PRICE = 1000;

1) 구매 금액 입력 가능
  * 구매 금액 입력 받기
      * input : new Scanner(System.in)
      * output : int totalAmount
  * 총 갯수 구하기
      * int totalLottoCount = 구매 금액 / 1매 가격
    
2) 수동 매수 입력 기능
  * 수동 매수 입력 받기
    * input : new Scanner(System.in)
    * output : int manualLottoCount
    
3) 수동 번호 입력 기능
  * 입력받은 수동매수와 수동번호로 로또 리스트를 반환하는 기능
  * 로또번호 문자열 리스트를 split 메서드로 파싱 및 Integer로 형변환 메서드 구현(lottoNumberPaser)
    * input : List<String> lottoInputList
    * output : List<LottoNumber> lottoList
    
4) 자동으로 나머지 매수 로또를 생성하는 기능
  * 자동매수 갯수 구하기
    * int autoLottoCount = 총 로또 갯수(totalLottoCount) - 수동 로또 갯수(manualLottoCount)
  * 자동매수 만큼 로또를 생성하는 메서드 구현
    * autoNumCreate()
      * input : int autoLottoCount
      * output : List<LottoNumber> autoLottoList
      * 일단은 이중포문으로 Random함수 통해 로또 생성하고 이후 Stream API활용해 리팩토링 해볼것.
    
5) 수동 로또목록과 자동 로또목록을 합친후 출력
  * 수동,자동 로또목록 병합.
    * List<LottoNumber> lottoList
  * 로또 번호를 문자열로 출력하기 위해 LottoNumber 클래스의 toString() 메서드 구현
  
6) 지난주 당첨번호와 보너스 볼
  * 지난주 당첨번호 입력받고 정수로 파싱 
    * int winNumbers = new int[6] (lottoNumberPaser 리턴값)
    * int bonusBall = scan.nextInt()
    
7) 당첨 통계 추출
  * 당첨번호화 로또 번호들로 당첨여부 파악하는 메서드 구현. - winResult
  * 몇등으로 몇번 당첨이 되었는지에 대한 정보와 수익률을 계산하는 클래스 구현 - LottoResult   
    * winResult()
      * input : int winNumbers, int bonusBall, List<LottoNumber> lottoList 
      * output : LottoResult

8) 당첨 통계와 수익률 출력 형식을 LottoResult의 toString메서드로 구현.     


1. 동작하는 쓰레기 코드 -> 그후에 리펙토링
스캐너 : 
2. 기능목록 보완 
3. 크롤링 코드 갈무리후 머지 리퀘스트

1. develop pull 받고
2. git pull --rebase origin develop
3. 충돌있다면 해결후 git rebase --continue
4. git push origin 개인브랜치
5. 이후 gitlab에서 merge Requset