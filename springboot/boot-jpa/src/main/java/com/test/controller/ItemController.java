package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.domain.Item;
import com.test.repository.ItemRepository;

@Controller
public class ItemController {

	//CRUD
	// - JpaRepository 구현체
	@Autowired
	private ItemRepository itemRepo;
	
	@GetMapping("/item/m1")
	public String m1(Model model) {
	
		System.out.println("m1");
		//'C'RUD
		// - 레코드 추가하기
		
		Item item = new Item();
		
		item.setName("잉크젯 프린터");
		item.setPrice(250000);
		item.setColor("yellow");
		item.setOwner("홍길동");
		
		//save > (JPA) > insert
		Item result = itemRepo.save(item);
		
		model.addAttribute("result", result);
		
		return "item/result";
	}
	
	@GetMapping("/item/m2")
	public String m2(Model model) {
		
		// - 레코드 추가하기
		
		//빌더 패턴(Builder Pattern)
		// - OOP에서 객체를 생성하는 패턴 중 하나
		// - 유연함
		
		Item item = Item.builder()
						.name("레이저 프린터")
						.price(300000)
						.color("black")
						.owner("아무개")
						.build();
		
		Item result = itemRepo.save(item);
				
		model.addAttribute("result", result);
		
		return "item/result";
	}
	
	@GetMapping("/item/m3")
	public String m3(Model model) {
		
		//C'R'UD
		// - 단일 레코드 읽기
		//Item item = itemRepo.getById("마우스");
		//model.addAttribute("result", item);
		
		//Item item = itemRepo.getOne("키보드");
		//model.addAttribute("result");
		
		Optional<Item> item = itemRepo.findById("노트북");
		model.addAttribute("result", item.get());
		
		
		return "item/result";
	}
	
	@GetMapping("/item/m4")
	public String m4(Model model) {
		
		//CR'U'D
		// - 레코드 수정하기
		//update시 모든 컬럼을 명시해야하므로 바뀌지 않는 데이터도 적어야한다.
	    //save 메소드는 select문을 먼저 실행하여서 기존에 없는 데이터면 insert, 있는 데이터면 update를 한다.

//		Item item = Item.builder()
//						.name("프린터")
//						.price(230000)
//						.color("white")
//						.owner("홍길동")
//						.build();
		
		Optional<Item> item = itemRepo.findById("프린터");
		
		if(item.isPresent()) {
			
			item.get().setPrice(24000);
			Item result = itemRepo.save(item.get());
			model.addAttribute("result", result);
		}
		
		
		return "item/result";
	}
		
	@GetMapping("/item/m5")
	public String m5(Model model) {
		
		//CRU'D'
		
		Optional<Item> item = itemRepo.findById("노트북");
		
		itemRepo.delete(item.get());
		
		
		return "item/result";
	}
	
	@GetMapping("/item/m6")
	public String m6(Model model) {
		
		//C'R'UD
		//Query Methods
		
		//다중 레코드 조회
		List<Item> list = itemRepo.findAll();
		
		model.addAttribute("list", list);
		
		return "item/result";
	}
	
	@GetMapping("/item/m7")
	public String m7(Model model) {
		
		//존재 유무 확인
		boolean bool = itemRepo.existsById("마우스");
		
		model.addAttribute("bool", bool);
		
		return "item/result";
	}
	
	@GetMapping("/item/m8")
	public String m8(Model model) {
		
		//카운트
		long count = itemRepo.count();
		
		model.addAttribute("count", count);
		
		return "item/result";
	}
	
	@GetMapping("/item/m9")
	public String m9(Model model) {
		
		//findByName을 자동으로 구현
		
		//Item item = itemRepo.findByName("마우스");
		//Item item = itemRepo.findByPrice(300000);
		
		//findBy 컬럼명
		// - By : Predicate Part. 조건절
		
		//Item item = itemRepo.findByNameIs("키보드");
		Item item = itemRepo.findByNameEquals("키보드");
		
		model.addAttribute("result", item);
		
		return "item/result";
	}
	
	@GetMapping("/item/m10")
	public String m10(Model model) {
		
		//And, Or
		//Item item = itemRepo.findByColorAndOwner("yellow", "홍길동");

		//Item item = itemRepo.findByColorAndOwnerAndPrice("black", "홍길동", 150000);
		
		Item item = itemRepo.findByColorOrPrice("gold", 300000);
		
		model.addAttribute("result", item);
		
		return "item/result";
	}
	
	@GetMapping("/item/m11")
	public String m11(Model model) {
		
		
		//List<Item> list = itemRepo.findByColor("white");
		
		//List<Item> list =itemRepo.findByColor("white", Sort.by(Sort.Direction.ASC, "price"));
		
		//List<Item> list = itemRepo.findByColorOrOwner("white", "홍길동");
		
		//findByNameLike()
		//findByNameIsLike()
		
		//findByNameNotLike()
		//findByNameIsNotLike()
		
		//- %, _ 를 직접 명시
		//List<Item> list = itemRepo.findByNameLike("키보드");
		//List<Item> list = itemRepo.findByNameLike("%키보드");
		
		// - findByName[Is]Startingwith
		// - findByName[Is]Endingwith
		// - findByName[Is]Containing
		

		List<Item> list = itemRepo.findByNameEndingWith("마우스");
		model.addAttribute("list", list);
		
		return "item/result";
	}
	
	@GetMapping("/item/m12")
	public String m12(Model model) {
		//[Is]Null. [Is]NotNull
		//- 컬럼값이 null인 레코드 검색

		//[Is]Empty, [Is]NotEmpty
		//- 컬럼값이 null이거나 빈문자열인 레코드

		//List<Item> list = itemRepo.findByOwnerNull();
		//List<Item> list = itemRepo.findByOwnerEmpty(); > 이건 안된당??

		//List<Item> list = itemRepo.findByOwnerNotNull();


		//정렬
		//List<Item> list = itemRepo.findAll(Sort.by(Sort.Direction.ASC, "price"));

		//List<Item> list = itemRepo.findAll(Sort.by("name")); // Direction 안쓰면 오름차순

		//List<Item> list = itemRepo.findAllByOrderByColor();

		//List<Item> list = itemRepo.findAllByOrderByColorDesc();

		//List<Item> list = itemRepo.findAllByOwnerOrderByColorDesc("홍길동");


		//[Is]GreaterThan, [Is]LessThan, [Is]Between
		//[Is]GreaterThanEqual, [Is]LessThanEqual

		//List<Item> list = itemRepo.findByPriceGreaterThan(100000);

		//List<Item> list = itemRepo.findByPriceGreaterThan(100000, Sort.by("price"));

		//List<Item> list = itemRepo.findByPriceLessThan(100000);

		//List<Item> list = itemRepo.findByPriceBetween(90000, 120000);

		//List<Item> list = itemRepo.findByOrderdateBetween("2023-06-25", "2023-06-27");

		//IgnoreCase
		//- 특정 컬럼의 대소문자를 구분하지 않고 검색

		//List<Item> list = itemRepo.findByColor("White");

		//List<Item> list = itemRepo.findByColorIgnoreCase("White");
		//where upper(item0_.color)=upper(?)


		//In, NotIn
		//- where color in ('yellow', 'blue')
		//List<String> colors = new ArrayList<String>();
		//colors.add("yellow");
		//colors.add("blue");

		//List<Item> list = itemRepo.findByColorIn(colors);

		List<Item> list = itemRepo.findByOwnerNotIn(new String[]{"홍길동", "아무개"});



		model.addAttribute("list", list);


		return "item/result";
	}


	@GetMapping("/item/m13")
	public String m13(Model model, @RequestParam("name") Item result) {

		//도메인 클래스 컨버터(Domain Class Converter)
		//- PK를 넘겨서, 바로 Entity를 조회할 수 있다.

		//item/m13?name=마우스

		//"마우스" > PK
		//Optional<Item> result = itemRepo.findById(name);
		//model.addAttribute("result", result.get());

		System.out.println(result);
		model.addAttribute("result", result);

		return "item/result";
	}


	@GetMapping("/item/m14/{name}")
	public String m14(Model model, @PathVariable("name") Item result) {

		//item/m13?name=마우스
		//item/m13/마우스
		model.addAttribute("result", result);

		return "item/result";
	}

	@GetMapping("/item/m15")
	public String m15(Model model) {

		//First
		//Top

		//이거 application.properties 가서 수정해야됨
		//spring.jpa.database-platform=org.hibernate.dialect.Oracle10gDialect
		//Item result = itemRepo.findFirstByOrderByPriceAsc();
		//Item result = itemRepo.findTopByOrderByPriceAsc();
		//model.addAttribute("result", result);

		List<Item> list = itemRepo.findTop3ByOrderByPriceDesc();

		model.addAttribute("list", list);


		return "item/result";
	}



	@GetMapping("/item/m16")
	public String m16(Model model, int page) {

		//페이징
		//매개 변수 > int page(페이지번호), int size(가져올 개수), Sort sort
		PageRequest pageRequest = PageRequest.of(page,  5, Sort.by("name"));

		List<Item> list = itemRepo.findPageListBy(pageRequest);

		model.addAttribute("list", list);

		return "item/result";
	}



	@GetMapping("/item/m17")
	public String m17(Model model) {

		//@Query
		//- 사용자 쿼리 작성
		//- 쿼리 메소드 키워드로 작성 불가능 쿼리 > 직접 SQL 작성

		//select * from Item

		//직접 만드는 쿼리의 메소드 이름은 아무렇게나 해도 된다!
		List<Item> list = itemRepo.findAllItem();

		model.addAttribute("list", list);

		return "item/result";
	}

	@GetMapping("/item/m18")
	public String m18(Model model, String color) {

		List<Item> list = itemRepo.findAllItemByColor(color);

		model.addAttribute("list", list);

		return "item/result";
	}



	/*
	@GetMapping("/item/m")
	public String m(Model model) {

		return "item/result";
	}
	 */
	
}
 