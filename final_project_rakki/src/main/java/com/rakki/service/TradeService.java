package com.rakki.service;

import java.util.List;

import com.rakki.domain.Criteria;
import com.rakki.domain.TradeVo;

public interface TradeService {
	List<TradeVo> getList();
	List<TradeVo> getList(Criteria cri);
	int getTotal(Criteria cri);
	int sellStatUpdate(TradeVo vo);
	int buyStatUpdate(TradeVo vo);
}
