package com.test.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

	List<Item> findByOwnerNull();

	List<Item> findByOwnerNotNull();

	List<Item> findAllByOrderByColor();

	List<Item> findAllByOrderByColorDesc();

	//인터페이스의 매개 변수의 이름은 중요하지 않다. 타입이 중요!!
	List<Item> findAllByOwnerOrderByColorDesc(String name);

	List<Item> findByPriceGreaterThan(int price);

	List<Item> findByPriceGreaterThan(int price, Sort by);

	List<Item> findByPriceLessThan(int price);

	List<Item> findByPriceBetween(int min, int max);

	List<Item> findByOrderdateBetween(String begin, String end);

	List<Item> findByColorIgnoreCase(String color);

	List<Item> findByColorIn(List<String> colors);

	List<Item> findByOwnerIn(String[] owners);

	List<Item> findByOwnerNotIn(String[] strings);

	Item findFirstByOrderByPriceAsc();

	Item findTopByOrderByPriceAsc();

	List<Item> findTop3ByOrderByPriceDesc();

	List<Item> findPageListBy(PageRequest pageRequest);

	@Query(value="select * from Item", nativeQuery = true)
	List<Item> findAllItem();

	//JPQL > Java Persistence Query Language
	// ? 자리에 :변수명 붙인다.
	@Query(value="select * from Item where color = :color", nativeQuery = true)
	List<Item> findAllItemByColor(String color);
}
