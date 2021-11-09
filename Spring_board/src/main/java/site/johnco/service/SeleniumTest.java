package site.johnco.service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import oracle.net.aso.b;

public class SeleniumTest {
	private final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	private final String WEB_DRIVER_PATH = "C:\\tool\\chromedriver95\\chromedriver.exe";
//	private String url = "https://www.namer.com";
	private String url = "http://localhost:8080/customLogin";
	private WebDriver driver;
	
	public SeleniumTest() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		driver = new ChromeDriver();
	}

	public static void main(String[] args) throws InterruptedException {
		SeleniumTest test = new SeleniumTest();
		test.crawl();
	}
	
	public void crawl() throws InterruptedException {
		driver.get(url);
		
//		list.get(0).findElement(By.tagName("input")).sendKeys("admin98");
//		list.get(1).findElement(By.tagName("input")).sendKeys("pw98");
		
//		driver.findElement(By.className("btn-primary")).submit();
//		
//		Thread.sleep(10000);
		int listCount = driver.findElements(By.cssSelector("table tbody tr")).size();
		for(int i = 0 ; i < listCount ; i++){
			List<WebElement> boardList = driver.findElements(select("table tbody tr"));
			WebElement tr = boardList.get(i);
			System.out.println(i);
			System.out.println(tr);
			System.out.println(tr.getText());
			tr.findElements(By.cssSelector("td")).get(1).findElement(select("a")).click();
			try{
				Thread.sleep(500);
				
				// 댓글 읽어오는 부분
				List<WebElement> list = driver.findElements(By.cssSelector("replyUL li"));
				list.forEach(li->{
					List<WebElement> divs = li.findElements(By.cssSelector("dic"));
					String title = divs.get(0).findElements(By.cssSelector("div")).get(0).getText();
					String content = divs.get(1).getText();
					
					System.out.println(title + " :: " + content);
				});
				driver.findElement(select("form a")).click();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}		
//		System.out.println(driver.getPageSource());
	static By select(String selector) {
		return By.cssSelector(selector);
	}
}
