package com.test.mapper;

import com.test.domain.AuthDTO;
import com.test.domain.MemberDTO;

public interface MemberMapper {

	int register(MemberDTO dto);

	void registerAuth(AuthDTO adto);
	
	MemberDTO read(String userid);

}
