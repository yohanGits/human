package site.johnco.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import site.johnco.domain.BoardVo;
import site.johnco.domain.Criteria;
import site.johnco.domain.ReplyCriteria;
import site.johnco.domain.ReplyVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	@Setter @Autowired
	private ReplyMapper mapper;
	
	@Test
	public void testExist(){
		assertNotNull(mapper);
	}
	
	@Test
	public void testInsert(){
		IntStream.range(0, 10).forEach(i->{
			ReplyVo vo = new ReplyVo();
			
			vo.setBno(15374L);
			vo.setReply("댓글 테스트 " + i);
			vo.setReplyer("댓글러");
			
			mapper.insert(vo);
		});
	}
	
	@Test
	public void testRead(){
		log.info(mapper.read(2L)); 
	}
	
	@Test
	public void testUpdate(){
		ReplyVo vo = new ReplyVo();
		vo.setReply("수정된 댓글");
		vo.setReplyer("수정맨");
		vo.setRno(4L);
		mapper.update(vo);
	}
	
	@Test
	public void testRemove(){
		log.info(mapper.delete(2L));
	}
	
	@Test
	public void testGetList(){
		ReplyCriteria criteria = new ReplyCriteria();
//		criteria.setLastRno(11L);
		mapper.getList(15374L, criteria).forEach(log::info);
	}
}
