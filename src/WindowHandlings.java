import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowHandlings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver", "D:\\Drivers\\Edge\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator(); 

		String parentwindow = it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		
		String username = driver.findElement(By.xpath("//div//p[@class='im-para red']")).getText();
//		driver.switchTo().window(parentwindow);
//		driver.findElement(By.id("username")).sendKeys(username);
		
		
		
	}

}
