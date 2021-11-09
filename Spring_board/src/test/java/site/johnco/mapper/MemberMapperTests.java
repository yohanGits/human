package site.johnco.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import site.johnco.domain.MemberVo;
import site.johnco.persistence.DataSourceTests;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTests {
	@Autowired @Setter
	private MemberMapper memberMapper;
	
	@Test
	public void testRead() {
		MemberVo vo = memberMapper.read("admin99");
		log.info(vo);
		vo.getAuths().forEach(log::info);
	}
}
