package site.johnco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import site.johnco.domain.Criteria;
import site.johnco.domain.ReplyCriteria;
import site.johnco.domain.ReplyVo;

public interface ReplyMapper {
	int insert(ReplyVo vo);
	ReplyVo read(Long rno);
	int update(ReplyVo vo);
	int delete(Long rno);
	List<ReplyVo> getList(@Param("bno") Long bno, @Param("cri") ReplyCriteria cri); // 두개 이상의 파라미터를 쓰기 위해서는 @param으로 이름 줘야함
}
