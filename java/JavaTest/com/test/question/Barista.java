package com.test.question;

public class Barista {

	Espresso makeEspresso(int bean) {
		
		Espresso espresso = new Espresso(bean);
		Coffee.countBean(bean);
		Coffee.countEspresso();
		
		return espresso;
	}
	
	Espresso[] makeEspressoes(int bean, int count) {
		
		Espresso[] espressoes = new Espresso[count];
		
		for(int i = 0; i < count; i++) {
			espressoes[i] = new Espresso(bean);
			Coffee.countBean(bean);
			Coffee.countEspresso();
		}
		
		return espressoes;
	}
	
	Latte makeLatte(int bean, int milk) {
		
		Latte latte = new Latte(bean, milk);
		Coffee.countBean(bean);
		Coffee.countMilk(milk);
		Coffee.countLatte();
		
		return latte;
	}
	
	Latte[] makeLattes(int bean, int milk, int count) {
		
		Latte[] lattes = new Latte[count];

		for(int i = 0; i < count; i++) {
			lattes[i] = new Latte(bean, milk);
			Coffee.countBean(bean);
			Coffee.countMilk(milk);
			Coffee.countLatte();
		}
		
		return lattes;
	}
	
	Americano makeAmericano(int bean, int water, int ice) {
		
		Americano americano = new Americano(bean, water, ice);
		Coffee.countBean(bean);
		Coffee.countWater(water);
		Coffee.countIce(ice);
		Coffee.countAmericano();
		
		return americano;
	}
	
	Americano[] makeAmericanos(int bean, int water, int ice, int count) {
		
		Americano[] americanos = new Americano[count];

		for(int i = 0; i < count; i++) {
			americanos[i] = new Americano(bean, water, ice);
			Coffee.countBean(bean);
			Coffee.countWater(water);
			Coffee.countIce(ice);
			Coffee.countAmericano();
		}
		
		return americanos;
	}
		
	void result() {
		
		System.out.println("\n=================================");
		System.out.println("판매 결과");
		System.out.println("=================================");
		
		System.out.println("\n---------------------------------");
		System.out.println("음료 판매량");
		System.out.println("---------------------------------");
		System.out.printf("에스프레소 : %d잔\n", Coffee.getEspresso());
		System.out.printf("아메리카노 : %d잔\n", Coffee.getAmericano());
		System.out.printf("라테 : %d잔\n", Coffee.getLatte());
		
		System.out.println("\n---------------------------------");
		System.out.println("원자재 소비량");
		System.out.println("---------------------------------");
		System.out.printf("원두 : %dg\n", Coffee.getBean());
		System.out.printf("물 : %,dml\n", Coffee.getWater());
		System.out.printf("얼음 : %d개\n", Coffee.getIce());
		System.out.printf("우유 : %,dml\n", Coffee.getMilk());
		
		System.out.println("\n---------------------------------");
		System.out.println("매출액");
		System.out.println("---------------------------------");
		System.out.printf("원두 : %,d원\n", Coffee.getBeanTotalPrice());
		System.out.printf("물 : %,.0f원\n", Coffee.getWaterTotalPrice());
		System.out.printf("얼음 : %,d원\n", Coffee.getIceTotalPrice());
		System.out.printf("우유 : %,d원\n", Coffee.getMilkTotalPrice());
		
	}
	
}
