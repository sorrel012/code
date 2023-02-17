package com.test.question;

public class Q093 {

	//잘못된 이름을 입력했을 경우 "잘못된 이름 대입" 출력 후 주인 없는 노트 출력이 맞나?
	//이름의 경우 '주인 없는 노트'라는 출력 조건이 있어서 null값 처리.
	//  - 다른 항목도 null값 처리 해줘야 하는지? 한다면 어떻게?
    public static void main(String[] args) {

    	Note note = new Note();

        note.setSize("B4");
        note.setColor("노란색");
        note.setPage(25);
        note.setOwner("홍길동");

        System.out.println(note.info());

        System.out.println();

        Note note2 = new Note();

        note2.setSize("A4");
        note2.setColor("검정색");
        note2.setPage(100);

        System.out.println(note2.info());

	} //main

}
