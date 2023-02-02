package com.test.java;

public class Ex06_Variable {
    public static void main(String[] args) {
	//과제
	//- 9개의 자료형
	//- 값형(8개) + 참조형(1개)   - 각 자료형 x10개씩
	// - 변수 생성 + 데이터 + 출력

	//1. 주위의 데이터 선별
	//2. 데이터 성격 파악 > 자료형(크기)
	//3. 변수 생성
	//4. 값 대입 > 상수
	//5. 출력


	//byte
	byte goal = 3;
	System.out.println("해트트릭은 한 경기에서 "+ goal + "을 넣는 것을 말한다.");

	byte month = 2;
	byte date = 2;
	System.out.println("오늘은 " + month + "월 " + date + "일이다.");

	byte temperature = -1;
	System.out.println("최저 기온은 " + temperature + "도이다.");

	byte time = 20;
	System.out.println("지금은 " + time + "시이다.");

	byte age = 26;
	System.out.println(age + "살입니다.");

	byte luckyNumber = 7;
	System.out.println("한국의 행운의 숫자는 " + luckyNumber + "이다.");

	byte family = 4;
	System.out.println("우리 가족은 " + family + "명이다.");

	byte myFavoriteNumber = 9;
	System.out.println("내가 가장 좋아하는 숫자는 " + myFavoriteNumber + "이다.");

	byte backNumber = 7;
	System.out.println("손흥민의 등번호는 " + backNumber + "번이다.");

	//short
	short height = 162;
	System.out.println("내 키는 " + height + "이다.");

	short year = 2023;
	System.out.println(year + "년은 계묘년이다.");

	short bornYear = 1998;
	System.out.println("나는 " + bornYear + "년에 태어났다.");

	short exchangeRate = 1225;
	System.out.println("오늘 환율은 " + exchangeRate + "원이다.");

	short flightSpeed = 900;
	short trainSpeed = 149;
	short veryHighTrainSpeed = 200;
	System.out.println("비행기의 평균 속력은 " + flightSpeed + "km/h, 일반 열차의 평균 속력은 " + trainSpeed + "km/h, "
		+ "고속 열차의 평균 속력은 " + veryHighTrainSpeed + "이다.");

	short weight = 635;
	System.out.println("역사상 몸무게가 가장 많이 나간 사람의 몸무게는 " + weight + "kg이다.");

	short londonToParis = 348;
	System.out.println("런던에서 파리까지의 거리는 약 " + londonToParis + "km이다.");

	short score = 400;
	System.out.println("수능은 " + score + "만점이다.");

	//int(21억)
	int mountainHeight = 884886;
	System.out.println("에베레스트 산의 높이를 cm로 환산하면 " + mountainHeight + "이다.");

	int koreaPopulation = 51558034;
	int seoulPopulation = 9428372;
	System.out.println("한국의 인구는 " + koreaPopulation + "명이고," + "서울의 인구는 " + seoulPopulation + "명이다.");

	int movieAudience = 17613682;
	System.out.println("한국에서 가장 많은 관객을 동원한 영화는 명량으로, " + movieAudience + "명이 관람했다.");

	int stadium974 = 40000;
	System.out.println("카타르 월드컵이 개최된 974 스타디움은 " + stadium974 + "명을 수용할 수 있다." );


	int million = 1000000;
	int billion = 1000000000;
	System.out.println("영어 million은 " + million + ", billion은 " + billion + "을 의미한다.");

	int lightSpeed = 300000;
	System.out.println("광속은 약 초속 " + lightSpeed + "km이다.");

	int circumferenceOfEarth = 46250;
	int diameterOfEarth = 12800000;
	System.out.println("지구의 둘레는 " + circumferenceOfEarth + "km이고, 지름은 " + diameterOfEarth + "m이다.");

	//long(22억 이상)
	long bugati = 3300000000L;
	System.out.println("부가티에서 단 3대만 판매한 차의 가격은 약 " + bugati + "라고 한다.");

	long transferFee = 130800000000L; // 호날두 이적료
	System.out.println("호날두의 이적료는 " + transferFee + "였다.");

	long annualIncom = 210000000000L; // 음바페 연봉
	System.out.println("음바페의 연봉은 " + annualIncom + "원이다.");

	long earthToSun = 14969000000000L;
	long diameterOfSun = 140000000000L;
	System.out.println("지구에서 태양까지의 거리는 " + earthToSun + "m이고, 태양의 지름은 " + diameterOfSun + "cm이다.");

	long priceOfHouse = 5000000000L;
	System.out.println("롯데타워에 있는 곳에 살기 위해서는 대략 " + priceOfHouse + "원이 필요하다.");

	long worldPopulation =  8045311447L;
	System.out.println("전세계의 인구수는 " + worldPopulation + "이다.");

	long bigbang = 13799000000L;
	System.out.println("빅뱅 이론은 우주의 탄생을 대략 " + 13799000000L + "년 전으로 추측한다.");

	long nominalGdp = 2071658000000000L;
	long realGdp = 1965000000000000L;
	System.out.println("한국의 명목 GDP는 " + nominalGdp + "이고, 실질 GDP는 " + realGdp + "이다.");

	//float
	float pi = 3.14f;
	System.out.println("많은 사람들은 원주율을 " + pi + "로 외우고 있다.");

	float battingAverage = 0.339f;
	System.out.println("이정후는 KBO리그 역대 통산 타율 " + battingAverage + "를 기록했다.");

	float interestRate = 4.3f; // 금리
	System.out.println("적금의 금리는 " + interestRate + "이다.");

	float length = 19.3f; //볼펜 길이
	System.out.println("볼펜의 길이는 " + length + "cm이다.");

	float cmToM = 0.01f;
	float mToKm = 0.001f;
	System.out.println("1cm를 m로 환산하면 " + cmToM + "이고, 1m를 km로 환산하면 " + mToKm + "이다.");

	float runningSpeed = 11.64f;
	System.out.println("우사인볼트의 초속은 " + runningSpeed + "m이다.");

	float earthDensity = 5.515f;
	System.out.println("지구의 밀도는 " + earthDensity + "g/cm^3이다.");

	float discountRate = 5.5f;
	System.out.println("그 상품은 " + discountRate + "% 할인 중이다.");

	float growth = 0.2f;
	System.out.println("키가 " + growth + "cm 컸다.");

	//double
	double piLong = 3.14159265358979;
	System.out.println("원주율을 조금 더 길게 알아보면 " + piLong + "이다.");
	double share1 = 1.28571428571;
	double share2 = 1.18181818181818181818;
	double share3 = 1.9166666666666666666;
	double share4 = 1.5151515151515151;
	System.out.println("----무한 소수의 일부----");
	System.out.println("9/7 = " + share1);
	System.out.println("13/11 = " + share2);
	System.out.println("23/12 = " + share3);
	System.out.println("50/33 = " + share4);

	double log8 = 0.9030899869919;
	double log13 = 1.1139433523068367692;
	double log55 = 1.74036268949424;
	double log27 = 1.43136376415898731188;
	double log37 = 1.5682017240669949968;
	System.out.println("----무한 소수의 일부----");
	System.out.println("log8 = " + log8);
	System.out.println("log13 = " + log13);
	System.out.println("log55 = " + log55);
	System.out.println("log27 = " + log27);
	System.out.println("log37 = " + log37);

	//char
	char a = 'a';
	char b = 'b';
	char c = 'c';
	char exclamationMark = '!';
	char e = 'e';
	char f = 'F';
	char g = 'g';
	char h = 'H';
	char questionMark = '?';
	char j = 'j';

	//boolean
	boolean isWeekday = false;
	boolean isAlphabet = false;
	boolean isConsonant = true;
	boolean isVowel = true;
	boolean isWhite = true;
	boolean isWarm = true;
	boolean lotto = false;
	boolean playing = false;
	boolean isKorean = true;
	boolean isWoman = true;

	System.out.println(exclamationMark + "와 " + questionMark + "는 알파벳인가? = " + isAlphabet);
	System.out.println(a + ", " + e + "는 모음인가? = " + isVowel);
	System.out.println(b + ", " + c + ", " + f + ", " + g + ", " + h + ", " + j + "는 자음인가? = " + isConsonant);
	System.out.println("토요일은 평일인가? = " + isWeekday);
	System.out.println("나는 여자이다. " + isWoman);
	System.out.println("나는 한국인이다. " + isKorean);
	System.out.println("로또 당첨(true)/낙첨(false) - " + lotto);
	System.out.println("현재 게임이 진행중인가? = " + playing);


	//String
	String name = "한효원";
	String fruit = "pineapple";
	System.out.println("내 이름은 " + name + "이고, 가장 좋아하는 과일은 " + fruit + "이다.");
	String season = "winter";
	String country = "Korea";
	System.out.println("현재 " + country + "의 계절은 " + season + "이다.");

	String sport = "football";
	System.out.println("영국은 " + sport + "를 좋아한다.");

	String snack = "chocolate";
	System.out.println("곧 발렌타인데이이다. 발렌타인데이에는 " + snack + "을 주고받는다.");

	String character = "MashiMaro";
	System.out.println("내가 가장 좋아하는 캐릭터는 " + character + "이다.");

	String furniture = "desk";
	System.out.println("내 방에는 " + furniture + "이 한 개 있다.");

	String drink = "water";
	System.out.println("가장 자주 마시는 것은 " + drink + "이다.");

	String color = "yellow";
	System.out.println("개나리는 " + color + "의 상징이다.");
    }
}
