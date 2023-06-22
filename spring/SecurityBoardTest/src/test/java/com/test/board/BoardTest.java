package com.test.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.test.service.BoardService;

import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class BoardTest {
	
	@Autowired
	private BoardService service;
	
//	@Test
//	public void testAdd() {
//
//		BoardDTO dto = new BoardDTO();
//
//		dto.setId("rabbit");
//		dto.setSubject("글쓰기 테스트3");
//		dto.setContent("내용3");
//
//		int result = service.add(dto);
//
//		log.info(result); //1 > 성공
//
//	}
//
//	@Test
//	public void testList() {
//
//		List<BoardDTO> list = service.list();
//
//		for(BoardDTO dto : list) {
//			log.info(dto);
//		}
//
//	}
//
//	@Test
//	public void testGet() {
//
//		BoardDTO dto = service.get("1");
//
//		log.info(dto);
//
//	}
//
//	@Test
//	public void testEdit() {
//
//		BoardDTO dto = new BoardDTO();
//
//		dto.setSeq("1");
//		dto.setSubject("수정한 제목입니다.");
//		dto.setContent("수정한 내용입니다.");
//
//		log.info(service.edit(dto));
//
//		log.info(service.get("1"));
//
//	}
	
	@Test
	public void testDel() {
		
		log.info(service.del("1"));
		
		log.info(service.list());
		
	}

}
