import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.transform.OutputKeys;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LinkCounts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//counting links on the page
		System.out.println(driver.findElements(By.tagName("a")).size());

		//limiting the scope of driver to footer only.
		WebElement footerdriver =  driver.findElement(By.id("gf-BIG"));
		//counting links in the footer
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		//limiting scope of driver to column
		WebElement columndriver = driver.findElement(By.xpath("//table[@class='gf-t']//tbody//tr//td[1]"));
		//counting links only in the first column
		int NumberofLinks = columndriver.findElements(By.tagName("a")).size();
		System.out.println(NumberofLinks);
		
		for(int i = 1;i<NumberofLinks;i++ ) {

		String clickingonLinks = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
		columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickingonLinks);
		Thread.sleep(5000L);
			
		}
		
		Set<String> listofwindows = driver.getWindowHandles();
		Iterator<String> a = listofwindows.iterator();
		while(a.hasNext()) {
			
			driver.switchTo().window(a.next());
			System.out.println(driver.getTitle());
			
		}
		
	}

}
