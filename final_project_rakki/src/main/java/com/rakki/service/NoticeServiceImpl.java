package com.rakki.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rakki.domain.Criteria;
import com.rakki.domain.NoticeVo;
import com.rakki.mapper.NoticeMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class NoticeServiceImpl implements NoticeService{
	private NoticeMapper mapper;
	
	@Override
	public List<NoticeVo> getList() {
		return mapper.getList();
	}

	@Override
	public void register(NoticeVo noticeVo) {
		mapper.insert(noticeVo);
	}

	@Override
	public NoticeVo get(Long nno) {
		return mapper.read(nno);
	}

	@Override
	public boolean modify(NoticeVo noticeVo) {
		return mapper.update(noticeVo);
	}

	@Override
	public boolean remove(Long nno) {
		return mapper.delete(nno);
	}

	@Override
	public List<NoticeVo> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
	
}