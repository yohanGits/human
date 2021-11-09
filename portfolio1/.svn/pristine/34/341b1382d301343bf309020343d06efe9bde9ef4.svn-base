package service;

import java.util.List;

import vo.Member;

public interface MemberService {

	// 할 일
	
	// 회원가입
	void join(Member member);
	// 로그인
	boolean login(String id, String pwd);
	// 탈퇴
	void memberOut(String pwd);
	
	// 정보수정
	void modify(Member member);
	
	// id 찾기
	Member findId(String name, String email);
	
	// 비밀번호 찾기
	Member findPwd(String id, String email);
	
	// 단일 회원 조회
	Member findBy(String id);
	Member findEmailBy(String email);
	
	// 회원 목록 조회
	List<Member> getMembers();


}
