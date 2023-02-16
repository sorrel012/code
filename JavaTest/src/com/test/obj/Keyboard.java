package com.test.obj;

public class Keyboard {

    private String model;
    private int price;

    /*
    //외부에서 직접 접근이 불가능한 private 변수를
    //public method가 중간에서 연결해줌.
    public void aaa(String a) {
        model = a;
    }

    public String ccc() {
        return model;
    }

    public void bbb(int b) {

        //유효성 검사
        if (b >= 0 && b <= 200000) {
            price = b;
        } else {
            System.out.println("가격 오류");
        }

    }

    public int ddd() {
        return price;
    }
    */

    public void setModel(String model) {
        //멤버변수(model) = 매개변수(model) > 멤버 변수 vs 지역 변수 충돌 발생 시 지역 변수 win!
        this.model = model; //this > 객체 접근(지정) 연산자
    }

    public String getModel() {
        return this.model;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }


}
