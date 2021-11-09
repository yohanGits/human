package site.johnco.service;

import java.util.List;

import site.johnco.domain.BoardVo;
import site.johnco.domain.Criteria;
import site.johnco.domain.ReplyCriteria;
import site.johnco.domain.ReplyVo;

public interface ReplyService {
	void register(ReplyVo vo);
	ReplyVo get(Long rno);
	boolean modify(ReplyVo vo);
	boolean remove(Long rno);
	List<ReplyVo> getList(ReplyCriteria cri, Long bno);
}
