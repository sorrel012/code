package com.test.di04;

public class BoardController {

	//의존 주입 도구
	//1. 생성자
	//2. Setter
	
	private BoardService service;
	
	public BoardController(BoardService service) {
		this.service = service;
	}
	
	
	//list.do
	public void doGet() {

		//BoardController > (의존) > BoardService > (의존) > BoardDAO
		
		//객체 생성 순서
		//1. BoardController
		//2. BoardService
		//3. BoardDAO
		
		//의존 객체
		//BoardService service = new BoardServiceImpl();
		//service.list();
		
		this.service.list();
		
	}
	
}
