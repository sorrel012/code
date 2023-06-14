package com.test.di05;

import org.springframework.stereotype.Repository;

//@Component (모르겠으면 Component로 통일)
@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Override
	public void list() {
		System.out.println("select * from tblBoard");
		
	}
}
