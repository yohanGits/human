package site.johnco.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import site.johnco.domain.ReplyVo;
import site.johnco.domain.ReplyCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyServiceTests {
	@Setter @Autowired
	private ReplyService service;
	
	@Test
	public void testClass(){
		log.info(service);
		log.info(service.getClass().getSimpleName());
	}
	
	
	@Test
	public void testExist(){
		assertNotNull(service);
	}
	
	@Test
	public void testGetList(){
		ReplyCriteria criteria = new ReplyCriteria();
		criteria.setLastRno(21L);
		service.getList(criteria, 15374L).forEach(log::info);
	}
	
	@Test
	public void testRegister(){
		ReplyVo vo = new ReplyVo();
		vo.setReply("서비스 테스트 등록글 제목");
		vo.setReplyer("서비스 테스터");
		vo.setBno(15374L);
		service.register(vo);
	}
	
	@Test
	public void testGet(){
		log.info(service.get(31L));
	}
	
	@Test
	public void testModify(){
		ReplyVo vo = new ReplyVo();
		vo.setReply("서비스 테스트 수정글 제목");
		vo.setReplyer("서비스 테스터");
		vo.setRno(12L);
		service.modify(vo);
	}
	
	@Test
	public void testRemove(){
		log.info(service.remove(13L));
	}
}
