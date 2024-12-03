import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.apache.commons.io.FileUtils;


public class InvokingTabandWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> handlewindow= driver.getWindowHandles();
		Iterator<String> it = handlewindow.iterator();
		
		String parentwindow = it.next();
	    String childwindow = it.next();
	    
	   driver.switchTo().window(childwindow);
	   driver.get("https://rahulshettyacademy.com");
	   

	  String coursetext = driver.findElements(By.xpath("//a[contains(@href, 'https://courses.rahulshettyacademy.com/p/')]")).get(1).getText();
	   
	  driver.switchTo().window(parentwindow);
	  
	  WebElement name = driver.findElement(By.cssSelector("[name='name']"));
	  
	  name.sendKeys(coursetext);
	  
	  File file = name.getScreenshotAs(OutputType.FILE);
	  
	  FileUtils.copyFile(file, new File("element.png"));
	  
	  System.out.println(name.getRect().getDimension().getWidth());
	  System.out.println(name.getRect().getDimension().getHeight());
	}

}
