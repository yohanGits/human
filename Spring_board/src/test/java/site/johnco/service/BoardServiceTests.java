package site.johnco.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import site.johnco.domain.BoardVo;
import site.johnco.domain.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	@Setter @Autowired
	private BoardService service;
	
	@Test
	public void testExist(){
		assertNotNull(service);
	}
	
	@Test
	public void testGetList(){
		service.getList(new Criteria(1, 6)).forEach(log::info);
	}
	
	@Test
	public void testRegister(){
		BoardVo boardVo = new BoardVo();
		boardVo.setTitle("서비스 테스트 제목");
		boardVo.setContent("서비스 테스트 내용");
		boardVo.setWriter("서비스 테스터");
		service.register(boardVo);
	}
	
	@Test
	public void testGet(){
		log.info(service.get(7L));
	}
	
	@Test
	public void testModify(){
		BoardVo boardVo = new BoardVo();
		boardVo.setTitle("서비스 테스트 수정글 제목");
		boardVo.setContent("서비스 테스트 수정글 내용");
		boardVo.setWriter("서비스 테스터");
		boardVo.setBno(2L);
		service.modify(boardVo);
	}
	
	@Test
	public void testRemove(){
		log.info(service.get(15L));
		log.info(service.remove(15L));
		log.info(service.get(15L));
	}
	
	@Test
	public void testGetTotal(){
		log.info(service.getTotal(new Criteria()));
	}
}
