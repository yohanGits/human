package com.rakki.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.rakki.domain.AddressVo;
import com.rakki.domain.AuthVo;
import com.rakki.domain.MemberVo;
import com.rakki.mapper.AddressMapper;
import com.rakki.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Service
@Log4j
@AllArgsConstructor
public class AddressServiceImpl implements AddressService{
	
	AddressMapper addressmapper;
	
	@Override
	public void insertAddress(Map<String, Object> adr) {
		addressmapper.insertAddress(adr);
	}

	@Override
	public List<AddressVo> getAddress(String id) {
		
		return addressmapper.getAddress(id);
	}

	@Override
	public void updateAddress(Map<String, Object> adr) {
		addressmapper.updateAddress(adr);
	}

	@Override
	public void deleteAddress(String id) {
		addressmapper.deleteAddress(id);
	}
	
	

	
	
}
