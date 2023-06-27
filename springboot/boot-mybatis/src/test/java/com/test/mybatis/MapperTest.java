package com.test.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.mapper.MyBatisMapper;

import lombok.extern.slf4j.Slf4j;

//대상 & 테스트 > 패키지 동일해야 함!
@SpringBootTest
@Slf4j
public class MapperTest {
	
	@Autowired
	private MyBatisMapper mapper;
	
	@Test
	public void testMaper() {
		
		log.info(mapper.time());
	}

}
