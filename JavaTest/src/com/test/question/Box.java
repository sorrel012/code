package com.test.question;

public class Box {

	private Macaron[] list = new Macaron[10];

	public void cook() {
		
		String[] colors = {"red", "blue", "yellow", "white", "pink", "purple", "green", "black"};
		
		for (int i = 0; i < 10; i++) {
			
			Macaron macaron = new Macaron();

			macaron.setSize( ( (int) (Math.random() * 11) + 5 ) );
			macaron.setColor(colors[(int)(Math.random() * 7)]);
			macaron.setThickness( ( (int) (Math.random() * 20) + 1 ) );
			
			list[i] = macaron;
			
			
			
		}
		
		System.out.println("마카롱을 10개 만들었습니다.\n");
				
	} //cook
	
	public void check() {

		int count = 0;
		
		for(int i = 0; i < 10; i++ ) {
			
			if(list[i].getPass() == 3) {
				list[i].setResult("합격");
				count++;
				
			}
			
		}
		
		System.out.println("[박스 체크 결과]");
		System.out.printf("QC 합격 개수 : %d개\n", count);
		System.out.printf("QC 불합격 개수 : %d개\n\n", 10 - count);
				
	} //check
	
	public void list() {

		for(int i = 0; i < 10; i++ ) {
			System.out.println(i+1 + "번 마카롱 : " + list[i].info());
		}
		
	} //list

}
