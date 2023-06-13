package com.test.di03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * 
 @Component : <bean> 태그와 동일한 역할
 	> 스프링이 관리하는 객체
 	
 @Autowired : 의존주입 어노테이션
 	> 아래에 있는 대상에 객체를 주입해 주세요.
 	
*/

@Component
public class Hong {

	//4.
	@Autowired
	private Pen pen;
	
	//3. lombok
//	@Setter(onMethod_ = @Autowired)
//	private Pen pen;
	
	//1. 생성자
//	@Autowired
//	public Hong(Pen pen) {
//		this.pen = pen;
//	}
	
	
	//2. Setter
//	@Autowired
//	public void setPen(Pen pen) {
//		this.pen = pen;
//	}
	
	
	public void run() {
		pen.write();
	}
	
}
