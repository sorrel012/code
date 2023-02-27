package com.test.question;

public class Packer {

	private static int pencilCount;
	private static int eraserCount;
	private static int ballPoinPenCount;
	private static int rulerCount;
	
	public void packing(Pencil pencil) {
		System.out.println(pencil.info());
		System.out.println("포장을 완료했습니다.");
		pencilCount++;
	}
	
	public void packing(Eraser eraser){
		System.out.println(eraser.info());
		System.out.println("포장을 완료했습니다.");
		eraserCount++;
	}
	
	public void packing(BallPointPen ballPointPen){
		System.out.println(ballPointPen.info());
		System.out.println("포장을 완료했습니다.");
		ballPoinPenCount++;
	}
	
	public void packing(Ruler ruler){
		System.out.println(ruler.info());
		System.out.println("포장을 완료했습니다.");
		rulerCount++;
	}
	
	public void countPacking(int type){
		System.out.println("\n=====================");
		System.out.println("포장 결과");
		System.out.println("=====================");
		
		switch(type) {
		case 0:
			System.out.printf("연필 %d회\n", Packer.pencilCount);
			System.out.printf("지우개 %d회\n", Packer.eraserCount);
			System.out.printf("볼펜 %d회\n", Packer.ballPoinPenCount);
			System.out.printf("자 %d회\n", Packer.rulerCount);
			break;
		case 1:
			System.out.printf("연필 %d회\n", Packer.pencilCount);
			break;
		case 2:
			System.out.printf("지우개 %d회\n", Packer.eraserCount);
			break;
		case 3:
			System.out.printf("볼펜 %d회\n", Packer.ballPoinPenCount);
			break;
		case 4:
			System.out.printf("자 %d회\n", Packer.rulerCount);
			break;
		}
		
	}
	
}
