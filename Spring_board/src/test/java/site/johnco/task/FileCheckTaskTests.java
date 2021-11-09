package site.johnco.task;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import site.johnco.service.BoardServiceTests;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class FileCheckTaskTests {
	@Setter @Autowired
	private FileCheckTask task;
	
	@Test
	public void testExist() {
		assertNotNull(task);
		log.info(task);
	}
	
	@Test
	public void testCheckFiles() {
		task.checkFiles();
	}
	
}
