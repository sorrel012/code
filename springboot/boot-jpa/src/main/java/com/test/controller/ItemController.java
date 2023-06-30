package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	
	/*
	@GetMapping("/item/m")
	public String m(Model model) {
		
		return "item/result";
	}
	*/
	
}
 