package com.test.domain;

import java.util.List;

import lombok.Data;

@Data
public class AddressDTO {
	
	private String seq;
	private String name;
	private String age;
	private String address;
	
	private List<EmailDTO> email;

}
