package com.test.persistence;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTest {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void sessionTest() {
		
		assertNotNull(sqlSessionFactory);
		
		// SAXParseException > XML에서 오류가 난 것!
		// Well-formed XML > 반드시 루트 태그가 존재해야 한다.
		
		//SqlSessionTemplate
		SqlSession session = sqlSessionFactory.openSession();
		
		//Namespace.id
		String time = session.selectOne("test.time");
		log.info(time);
		
	}
	
}
