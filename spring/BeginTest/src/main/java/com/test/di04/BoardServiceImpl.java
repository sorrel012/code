package com.test.di04;

public class BoardServiceImpl implements BoardService {

	private BoardDAO dao;
	
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void list() {
		
		//목록 가져오기
		//BoardDAO dao = new BoardDAOImpl();
		//dao.list();
		
		this.dao.list();
		
	}
	
}
