package com.test.question;

import java.util.Calendar;

public class Bugles {

	private int price;
	private int weight;
	private Calendar creationTime;
	private int expiration;

	public int getPrice() {
		return this.price;
	}

	public int getExpiration() {

		Calendar c = Calendar.getInstance();

		this.expiration = this.expiration- (int)( (c.getTimeInMillis() - creationTime.getTimeInMillis()) / 1000 / 60 / 60 / 24 ) - 1; //오늘 제외 남은 날

		return this.expiration;
	}

	public void setSize(int weight) {

		if(weight == 300 || weight == 500 || weight == 850) {

			this.weight = weight;

			if(weight == 300) {
				this.price = 850;
				this.expiration = 7;

			} else if(weight == 500) {
				this.price = 1200;
				this.expiration = 10;

			} else {
				this.price = 1950;
				this.expiration = 15;
			}

		} else {
			System.out.println("올바른 용량이 아닙니다.");
			this.weight = 0; //null 방지
		}

	}

	public void setCreationTime(String date) {

		String[] dates = date.split("-");

		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.YEAR, Integer.parseInt(dates[0]));
		calendar.set(Calendar.MONTH, Integer.parseInt(dates[1]) - 1);
		calendar.set(Calendar.DATE, Integer.parseInt(dates[2]));

		this.creationTime = calendar;
	}

	public void eat() {

		if(this.expiration >= 0) {
			System.out.println("과자를 맛있게 먹습니다.\n");
		} else {
			System.out.println("유통기한이 지나 먹을 수 없습니다.\n");
		}

	}

}
