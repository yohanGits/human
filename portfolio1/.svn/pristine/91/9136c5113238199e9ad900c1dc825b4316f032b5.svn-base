package service;

import java.util.List;

import vo.Reply;

public interface ReplyService {
	// 댓글 쓰기
	void write(Reply reply);
	// 댓글 목록
	List<Reply> list(Long bno);
	// 댓글 단일 조회
	Reply get(Long rno);
	// 댓글 삭제
	void remove(Long rno);
	// 게시글 삭제시 댓글 전체 삭제
	void removeAll(Long bno);
	// 댓글 아이디 null
	void setNull(String id);
	// 댓글 수정
	void modifyReply(Reply reply);
}