package com.test.domain;

import java.util.List;

import lombok.Data;

@Data
public class MemberDTO {
	
	private String userid;
	private String userpw;
	private String username;
	private String regdate;
	private String updatedate;
	private String enabled;
	
	private List<AuthDTO> authlist;

}
