package com.rakki.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rakki.domain.Criteria;
import com.rakki.domain.TradeVo;
import com.rakki.mapper.TradeMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class TradeServiceImpl implements TradeService{
	TradeMapper mapper;
	@Override
	public List<TradeVo> getList() {
		return mapper.getOnTradeList();
	}

	@Override
	public List<TradeVo> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}

	@Override
	public int sellStatUpdate(TradeVo vo) {
		return mapper.sellStatUpdate(vo);
	}

	@Override
	public int buyStatUpdate(TradeVo vo) {
		return mapper.buyStatUpdate(vo);
	}
	
}
