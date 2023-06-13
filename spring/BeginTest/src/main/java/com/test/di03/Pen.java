package com.test.di03;

import org.springframework.stereotype.Component;

@Component
public class Pen {
	
	public void write() {
		System.out.println("펜으로 글씨를 적습니다.");
	}

}
