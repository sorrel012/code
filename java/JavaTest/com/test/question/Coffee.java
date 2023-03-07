package com.test.question;

public class Coffee {
	
	private static int bean;
	private static int water;
	private static int ice;
	private static int milk;
	
	private static int beanUnitPrice = 1;
	private static double waterUnitPrice = 0.2;
	private static int iceUnitPrice = 3;
	private static int milkUnitPrice = 4;
	
	private static int beanTotalPrice;
	private static double waterTotalPrice;
	private static int iceTotalPrice;
	private static int milkTotalPrice;

	private static int espresso;
	private static int americano;
	private static int latte;
	
	public static void countBean(int bean) {
		Coffee.bean += bean;
	}
	
	public static void countWater(int water) {
		Coffee.water += water;
	}
	
	public static void countIce(int ice) {
		Coffee.ice += ice;
	}
	
	public static void countMilk(int milk) {
		Coffee.milk += milk;
	}

	public static void countEspresso() {
		Coffee.espresso++;
	}

	public static void countLatte() {
		Coffee.latte++;
	}

	public static void countAmericano() {
		Coffee.americano++;
	}

	public static int getBean() {
		return bean;
	}

	public static int getWater() {
		return water;
	}

	public static int getIce() {
		return ice;
	}

	public static int getMilk() {
		return milk;
	}

	public static int getEspresso() {
		return espresso;
	}

	public static int getAmericano() {
		return americano;
	}

	public static int getLatte() {
		return latte;
	}
	
	public static int getBeanTotalPrice() {
		
		Coffee.beanTotalPrice = Coffee.beanUnitPrice * Coffee.bean;
		return Coffee.beanTotalPrice;
		
	}

	public static double getWaterTotalPrice() {

		Coffee.waterTotalPrice = Coffee.waterUnitPrice * Coffee.water;
		return Coffee.waterTotalPrice;

	}

	public static int getIceTotalPrice() {

		Coffee.iceTotalPrice = Coffee.iceUnitPrice * Coffee.ice;
		return Coffee.iceTotalPrice;

	}

	public static int getMilkTotalPrice() {

		Coffee.milkTotalPrice = Coffee.milkUnitPrice * Coffee.milk;
		return Coffee.milkTotalPrice;

	}

}
