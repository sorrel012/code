package com.test.mapper;

import java.util.List;

import com.test.domain.AddressDTO;
import com.test.domain.EmailDTO;

public interface AddressMapper {

	public void add(AddressDTO dto);

	public void addEmail(EmailDTO edto);

	public List<AddressDTO> list();

	public List<EmailDTO> elist(String pseq);

	public List<AddressDTO> list2();
	
}
