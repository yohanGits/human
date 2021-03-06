package com.rakki.service;

import java.util.List;
import java.util.Map;

import com.rakki.domain.AuthVo;
import com.rakki.domain.MemberVo;

public interface MemberService {
	
	MemberVo login(String id) throws Exception;
	
	/* 김우성
	 * 회원가입 메서드
	 * 2021-10-30
	 * */
	void insertMember(Map<String, Object> map);
	
	/* 김우성
	 * 회원가입(권한) 메서드
	 * 2021-10-30
	 * */
	void insertAuth(Map<String, Object> auth);
	/* 김우성
	 * 회원 정보 수정 메서드
	 * 2021-11-03
	 * */
	void modify(MemberVo member) throws Exception;
	
	/* 김우성
	 * 회원 탈퇴 메서드
	 * 2021-11-03
	 * */
	void delete(String id); 
	
	/* 김우성
	 * 회원 Auth 삭제 메서드
	 * 2021-11-03
	 * */
	void deleteAuth(String id);

}
