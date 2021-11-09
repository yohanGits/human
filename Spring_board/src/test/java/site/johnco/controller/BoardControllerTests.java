package site.johnco.controller;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import site.johnco.domain.BoardVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j

// Test Controller
@WebAppConfiguration
public class BoardControllerTests {
	@Autowired @Setter
	private WebApplicationContext ctx;
	private MockMvc mvc;
	
	@Before
	public void setup(){
		mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testExist(){
		assertNotNull(ctx);
		assertNotNull(mvc);
		log.info(ctx);
		log.info(mvc);
	}
	
	@Test
	public void testList() throws Exception{
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/board/list")
				.param("pageNum", "2")
				.param("amount", "4")
				)
		.andReturn()
		.getModelAndView()
		.getModelMap();
		
		List<?> list = (List<?>) map.get("list");
		list.forEach(log::info);
	}
	
	@Test
	public void testRegister() throws Exception{
		ModelAndView mav = mvc.perform(
				MockMvcRequestBuilders.post("/board/register")
				.param("title", "컨트롤러 테스트 글 제목")
				.param("content", "컨트롤러 테스트 글 내용")
				.param("writer", "컨트롤러 테스터"))
				.andReturn()
				.getModelAndView();
		
		log.info(mav.getViewName());
	}
	
	@Test
	public void testGet() throws Exception{
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "1"))
		.andReturn()
		.getModelAndView()
		.getModelMap();
		
		log.info(map.get("board"));
	}
	
	@Test
	public void testModify() throws Exception{
		ModelAndView mav = mvc.perform(
				MockMvcRequestBuilders.post("/board/modify")
				.param("title", "컨트롤러 테스트 글 제목 수정")
				.param("content", "컨트롤러 테스트 글 내용 수정")
				.param("writer", "컨트롤러 테스터")
				.param("bno", "1"))
				.andReturn()
				.getModelAndView();
		
		log.info(mav.getViewName());
	}
	
	@Test
	public void testRemove() throws Exception{
		ModelAndView mav = mvc.perform(
				MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "1")
				)
				.andReturn()
				.getModelAndView();
		
		log.info(mav.getViewName());
	}
}




