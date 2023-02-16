package com.test.obj;

public class Ex41_Access {

    public static void main(String[] args) {

        Book b1 = new Book();

        b1.a = 10;
        //	b1.b = 20; //The field Book.b is not visible
        //	b1.c = 30; //c cannot be resolved or is not a field
        System.out.println(b1.a);
        System.out.println();

        //키보드

        Keyboard k1 = new Keyboard();

        //	k1.model = "K810";
        //	k1.price = 150000;
        //
        //	System.out.println(k1.model);
        //	System.out.println(k1.price);


        System.out.println();


        Keyboard k2 = new Keyboard();

        //	k2.model = "K380";
        //	k2.price = 2000000000; //컴파일 에러(x), 런타임 에러(x) .. 올바른 가격?
        //
        //  System.out.println(k2.model);
        //  System.out.println(k2.price);

        System.out.println();

        //	k2.aaa("K380");
        //	k2.bbb(35000);
        //
        //	System.out.println(k2.ccc());
        //	System.out.println(k2.ddd());


        k2.setModel("K380");
        System.out.println(k2.getModel());

        k2.setPrice(35000);
        System.out.println(k2.getPrice());

    } //main


}
