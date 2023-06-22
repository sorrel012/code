package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.domain.BoardDTO;
import com.test.mapper.BoardMapper;

/*
@Controller
public class TestController {

	@GetMapping("/m1.do")
	public @ResponseBody BoardDTO m1() {
	
		BoardDTO dto = new BoardDTO();
		
		dto.setSeq("1");
		dto.setSubject("제목입니다.");
		dto.setContent("내용입니다.");
		dto.setRegdate("2023-06-23");
		dto.setId("hong");
		
		return dto;
	}
	
}
*/

@RestController
public class TestController {
	
	@Autowired
	private BoardMapper mapper;
	
	@GetMapping("/m1.do")
	public BoardDTO m1() {
	
		BoardDTO dto = new BoardDTO();
		
		dto.setSeq("1");
		dto.setSubject("안녕하세요.");
		dto.setContent("장기성입니다.");
		dto.setRegdate("2023-06-13");
		dto.setId("jang");
		
		return dto;
	}
	
	//Board > CRUD
	
	//글쓰기
	//1. http://localhost/rest/board
	//2. POST
	//3. return int
	//@RequestMapping(value="/board", method=RequestMethod.POST)
	
	//REST 서비스 > 테스트 > 클라이언트 툴(Postman, Insomnia, VS Code, 크롬 확장 프로그램 등)

	@PostMapping("/board")
	public int add(@RequestBody BoardDTO dto) {
		
		int result = mapper.add(dto);
		
		return result;
	}
	
	//목록 가져오기
	//1. http://localhost/rest/board
	//2. GET
	//3. List<DTO> -> JSON 변환
	
	@GetMapping("/board")
	public List<BoardDTO> list() {
		
		return mapper.list();
	}
	
	//요소 수정하기
	//1. http://localhost/rest/board/5
	//2. PUT or PATCH(보통 PUT)
	//3. return int
	
	@PutMapping("/board/{seq}") //경로 변수(PathVariable)
	public int edit(@RequestBody BoardDTO dto, @PathVariable("seq") String seq) {
		
		dto.setSeq(seq);
		
		return mapper.edit(dto);
	}
	
	//삭제하기
	//1. http://localhost/rest/board/6
	//2. DELETE
	//3. return int
	
	@DeleteMapping("/board/{seq}")
	public int del(@PathVariable("seq") String seq) {
		
		return mapper.del(seq);
		
	}
	
	//상세보기
	//1. http://localhost/rest/board/6
	//2. GET
	//3. return DTO
	@GetMapping("/board/{seq}")
	public BoardDTO get(@PathVariable("seq") String seq) {
		
		return mapper.get(seq);
	}

}

