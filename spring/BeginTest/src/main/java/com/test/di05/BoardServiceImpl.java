package com.test.di05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Component
//(서비스 부분)
@Service
public class BoardServiceImpl implements BoardService {

	private BoardDAO dao;
	
	@Autowired
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
