package dao;

import vo.Reply;

public class ReplyDaoTests {
	public static void main(String[] args) {
		ReplyDao dao = new ReplyDao();
		MemberDao dao1 = new MemberDao();
		// 댓글 쓰기 테스트
//		dao.insert(new Reply((long) 2, "테스트", "테스트", null	, "javaman", 1L));
//		System.out.println(dao.select((long) 2));
		
		// 댓글 리스트 조회 테스트
//		dao.list(1L).forEach(System.out::println);
		
		// 댓글 조회 테스트
//		System.out.println(dao.select((long) 2));
		
		// 탈퇴회원위한 idnull 테스트
//		dao.idNull("hong");
//		System.out.println(dao1.findBy("hong"));
		
		// 댓글 삭제 테스트
//		dao.delete(3L);
//		dao.list(1L).forEach(System.out::println);
		
		// 게시글 삭제시 모든 댓글 삭제 테스트
//		dao.deleteAll(786L);
//		dao.list(786L).forEach(System.out::println);
		
		// 댓글 수정 테스트
//		dao.updaterep(new Reply(2L, "수정 테스트", "수정 테스트", null, "javaman", 1L));
//		System.out.println(dao.select((long) 2));
		
		
	}
}
