package com.test.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	//인터페이스 매퍼+ 어노테이션(SQL)
	@Select("select sysdate from dual")
	public String getTime();
	
	//XML 매퍼 파일 사용하기
	public String getTime2();
	
}
