package com.test.obj;

public class Desk {

    private String color;
    private String[] colors = {"white", "black", "blue", "yellow"};

    public String getColor() {
        return color;
    }

    public void setColor(String color) {

        int count = 0;

        for(String c : colors) {
            if(c.equals(color)) {
                count++;
            }
        }

        if(count == 1) {
            this.color = color;
        } else {
            System.out.println("잘못된 색상 대입");
        }

    }

}
