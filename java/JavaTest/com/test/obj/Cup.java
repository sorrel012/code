package com.test.obj;

public class Cup {

    public String color;
    private int weight;
    private int price;
    private String type;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setWeight(int weight) {
       this.weight = weight;
    }

    public int getPrice() {
        return this.price;
    }


    public int getLevel() { //얘도 getter인지? 멤버 변수를 읽는 것은 아닌데..

        if (this.weight < 500 && this.price < 1000) {
            return 1; //등

        } else if (this.weight < 700 && this.price < 5000) {
            return 1;

        } else {
            return 3;
        }

    }

}
