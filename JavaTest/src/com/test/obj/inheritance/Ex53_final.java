package com.test.obj.inheritance;

public class Ex53_final {
	
	public static void main(String[] args) {

		//지역 변수
		int a = 10;
		a = 20;
		a = 30;
		
		final int b = 10;
		//b = 20; > 불가
		
		// 비권장 > 일반 변수처럼 보임
		final int c;
		c = 10;
		
		// 권장
		final int d= 10;
		
		//상수명은 모두 대문자로 작성 > 변수와 구분짓기 위해
		final double PI = 3.14;
		
		
		FinalParent finalParent = new FinalParent();
		
		finalParent.test();

	} //main
	
}


class Gender {
	
	//남자(1), 여자(2)
	public final int MALE = 1;
	public final int FEMALE = 2;
	
} //Gender


class FinalParent {
	
	public final void test() {
		System.out.println("부모가 만든 메소드");
		System.out.println(num());
	}
	
	public final int num() {
		return 100;
	}
	
}

/*
class FinalChild extends FinalParent {
	
	@Override
	public void test() {
		System.out.println("자식이 재정의한 메소드");
	}
	
	@Override
	public int num() {
		return 200;
	}
	
}
*/

//상속을 할 수 없게 금지함. > 자식 낳을 수 xx
final class FinalMember {
	
	
}

