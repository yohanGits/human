package service;

import dao.MemberDao;
import vo.Board;

public class BoardServiceTests {
	public static void main(String[] args) {
		BoardService service = new BoardServiceImpl();
		MemberDao dao1 = new MemberDao();
		
		// 글쓰기 테스트
//		Long bno = service.write(new Board(null, "글쓰기 테스트에서 작성된 글 제목",
//				"글쓰기 테스트에서 작성된 글 내용", null, "babamba", 1L, null, null));
//		System.out.println(bno);
		
		// 글 단일 조회 테스트
//		System.out.println(service.read(1L));
		
//		// 목록 조회 테스트
//		service.list(new Criteria(1, 10)).forEach(System.out::println);

//		// 글 수정 테스트
//		service.modify(new Board(2L, "수정 테스트에서 수정한 글", "수정 테스트에서 수정한 내용"));
//		System.out.println(service.read(2L));
		
//		// 삭제 테스트
//		service.remove(767L);
//		service.list().forEach(System.out::println);
		
		// 탈퇴회원 위한 idsetnull 테스트
//		service.setNull("hong");
//		System.out.println(dao1.findBy("hong"));
		
		// 카테고리별 게시글 개수
//		System.out.println(service.getCount(new Criteria(1, 10, 2)));
		
		// 폴더별 첨부파일 조회
//		System.out.println(service.readAttachByPath("210925"));
		
		// 첨부파일 삭제
//		service.removeAll(788L);
//		System.out.println(service.read(788L));
	}
	
}
