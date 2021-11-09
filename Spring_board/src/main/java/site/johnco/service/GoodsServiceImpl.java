//package site.johnco.service;
//
//import org.springframework.stereotype.Service;
//
//import lombok.AllArgsConstructor;
//import site.johnco.domain.GoodsVo;
//import site.johnco.mapper.GoodsMapper;
//
//@Service
//@AllArgsConstructor
//public class GoodsServiceImpl implements GoodsService{
//	private GoodsMapper goodsMapper;
//
//	@Override
//	public void register(GoodsVo vo) {
//		goodsMapper.insert(vo);
//		vo.getAttachs().forEach(goodsMapper::insertAttach);
//				)
//}
