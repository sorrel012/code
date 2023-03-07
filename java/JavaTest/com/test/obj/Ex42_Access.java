package com.test.obj;

public class Ex42_Access {

    public static void main(String[] args) {

        Cup c1 = new Cup();

        //Getter + Setter > 읽기 쓰기 가능한 멤버 > 프로퍼티
        c1.setColor("white");
        System.out.println(c1.getColor());

        //Setter > 쓰기 전용 멤버
        c1.setWeight(500);

        //Getter > 읽기 전용 멤버
        System.out.println(c1.getPrice());

        // 계산된 프로퍼티
        System.out.println(c1.getLevel());

        System.out.println();
        System.out.println();


        Desk d1 = new Desk();

        d1.setColor("red");                 //Setter > 유효성 검사(예측이 불가능)
        System.out.println(d1.getColor());  //Getter > 유효성 검사(x) > 이미 Setter에서 걸렀음.
        System.out.println();

        d1.setColor("blue");
        System.out.println(d1.getColor());

    } //main

}
