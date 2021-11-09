package site.johnco.service;

import java.util.List;

import site.johnco.domain.AttachVo;
import site.johnco.domain.BoardVo;
import site.johnco.domain.Criteria;

public interface BoardService {
	void register(BoardVo boardVo);
	BoardVo get(Long bno);
	boolean modify(BoardVo boardVo);
	boolean remove(Long bno);
	List<BoardVo> getList(Criteria cri);
	int getTotal(Criteria cri);
	List<AttachVo> getAttachs(Long bno);
}
