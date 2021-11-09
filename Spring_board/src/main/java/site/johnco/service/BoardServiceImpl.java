package site.johnco.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import site.johnco.domain.AttachVo;
import site.johnco.domain.BoardVo;
import site.johnco.domain.Criteria;
import site.johnco.mapper.AttachMapper;
import site.johnco.mapper.BoardMapper;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	private BoardMapper boardMapper;
	private AttachMapper attachMapper;

	@Override @Transactional
	public void register(BoardVo boardVo) {
		boardMapper.insertSelectKey(boardVo);
		
		boardVo.getAttachs().forEach(attach->{
			attach.setBno(boardVo.getBno());
			attachMapper.insert(attach);
		});
	}

	@Override @Transactional
	public BoardVo get(Long bno) {
		// TODO Auto-generated method stub
		return boardMapper.read(bno);
	}

	@Override
	public boolean modify(BoardVo boardVo) {
		boolean result = boardMapper.update(boardVo) > 0;
		
		attachMapper.deleteAll(boardVo.getBno());
		if(result) {
			boardVo.getAttachs().forEach(vo->{
				vo.setBno(boardVo.getBno());
				attachMapper.insert(vo);
			});
		}
		
		return result;
	}

	@Override @Transactional
	public boolean remove(Long bno) {
		attachMapper.deleteAll(bno);
		return boardMapper.delete(bno) > 0;
	}

	@Override
	public List<BoardVo> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return boardMapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return boardMapper.getTotalCount(cri);
	}

	@Override
	public List<AttachVo> getAttachs(Long bno) {
		return attachMapper.findByBno(bno);
	}
	
	
	
}
