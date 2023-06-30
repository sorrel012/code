package com.test.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.test.domain.Item;

//JpaRepository<엔티티타입, PK자료형>
// - ItemRepository > 이름은 자유
// - 엔티티명 + Repository

public interface ItemRepository extends JpaRepository<Item, String> {
	
	//추상 메소드
	//1. JpaRepository 상속 메소드 > 기본
	//2. 사용자 정의 메소드 > 확장
	
	//Optional<Item> findById(String id)
	Item findByName(String name);
	Item findByNameIs(String name);
	Item findByNameEquals(String name);

	Item findByPrice(int price);
	
	Item findByColorAndOwner(String color, String owner);
	
	Item findByColorAndOwnerAndPrice(String color, String owner, int price);

	Item findByColorOrPrice(String color, int price);
	
	List<Item> findByColor(String color);
	
	List<Item> findByColor(String color, Sort sort);
	
	List<Item> findByColorOrOwner(String color, String owner);
	
	List<Item> findByNameLike(String word);
	
	List<Item> findByNameEndingWith(String word);
	
	
}
