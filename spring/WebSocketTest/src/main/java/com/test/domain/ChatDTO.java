package com.test.domain;

import lombok.Data;

@Data
public class ChatDTO {

	private String code;
	private String sender;
	private String receiver;
	private String content;
	private String regdate;
	
}
