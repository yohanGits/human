package site.johnco.sample;

import static org.junit.Assert.assertNotNull;

// spring-core
// spring-test
// junit

// spring-core
// aspectweaver
// aspectjrt

// spring-core
// spring-quartz
// quartz

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j // log라는 에그를 만들어줌
public class SampleTests {
	@Setter @Autowired
	private Restaurant restaurant;
//	static final Logger logger = Logger.getLogger(SampleTests.class); // 이렇게 로거를 사용해야 하는 것을 @log4j어노테이션으로 log.~로가능
	
	@Test  // junit 단위테스트 test메소드는 public이어야 한다. 
	public void testExist(){
		assertNotNull(restaurant);
		log.info(restaurant);
		log.info("========================");
		log.info(restaurant.getChef());
	}
}
