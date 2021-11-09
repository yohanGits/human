package site.johnco.mapper;

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
public class BoardMapperTests {
	@Setter @Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList(){
		mapper.getList().forEach(log::info);
//		mapper.getList();
	}
	
	@Test
	public void testGetListWithPaging(){
		Criteria cri = new Criteria();
		cri.setType("T");
		cri.setKeyword("내용");
		
		mapper.getListWithPaging(cri).forEach(log::info);
	}
	
	@Test
	public void testInsert(){
		BoardVo board = new BoardVo();
		board.setTitle("영속 테스트 제목");
		board.setContent("영속 테스트 내용");
		board.setWriter("영속 테스트");
		mapper.insert(board);
	}
	
	@Test
	public void testInsertSelectKey(){
		BoardVo board = new BoardVo();
		board.setTitle("영속 테스트 제목");
		board.setContent("영속 테스트 내용");
		board.setWriter("영속 테스트");
		log.info("befor :: " + board);
		mapper.insertSelectKey(board);
		log.info("after :: " + board);
	}
	
	@Test
	public void testRead(){
		log.info(mapper.read(6L));
	}
	
	@Test
	public void testUpdate(){
		BoardVo board = new BoardVo();
		board.setTitle("수정된 영속 테스트 제목");
		board.setContent("수정된 영속 테스트 내용");
		board.setWriter("수정한 영속 테스터");
		board.setBno(7L);
		log.info(mapper.update(board));
		log.info(mapper.read(7L));
	}
	
	@Test
	public void testDelete(){
		log.info(mapper.read(6L));
		log.info(mapper.delete(6L));
		log.info(mapper.read(6L));
	}
	
	@Test
	public void testGetTotalCount(){
		Criteria cri = new Criteria();
		cri.setType("T");
		cri.setKeyword("테스트");
		log.info(mapper.getTotalCount(new Criteria()));
	}
}
