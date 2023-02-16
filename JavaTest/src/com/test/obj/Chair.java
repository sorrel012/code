package com.test.obj;

public class Chair {

    private int a; //멤버 변수

    //클래스 멤버 변수의 생명 주기
    // -
    //      ~ new Chair(); > 실행될 때 태어남
    //

    public void test(int b) {

        int c;

        if (true) {
            int d;
        }


        //루프 변수 i의 생명 주기 : for 시작~끝
        for (int i = 0; i < 10; i++) {

            //for내의 변수 e의 생명 주기: for 1바퀴 > 반복
            int e; //10번 생성~소멸

        }

        Test t = new Test();

        //Test.Sub s = new Test.Sub();


    } //test

} //Chair


class Test {

    //일반적인 클래스 멤버 (멤버 변수, 멤버 메서드) > 99 정도... 1 > 클래스(내부 클래스, 중첩 클래스)

    private int a;

    public void bbb() {

    }

    class Sub{ //내부 클래스, 중첩 클래스

    }


}
