package com.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//JPA > Entity
// - 데이터베이스의 테이블 <- (연결) -> JPA의 엔티티
// - 매핑되는 테이블명과 엔티티의 이름을 동일하게 만든다.

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
	
	//엔티티가 참조하는 테이블의 컬럼 > 멤버 정의
	@Id
	private String name;
	
	private int price;
	private String color;
	private String owner;
	
	@Column(insertable = false, updatable = false)
	private String orderdate;

}
