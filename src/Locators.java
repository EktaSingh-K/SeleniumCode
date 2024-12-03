import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait -- 5 seconds timeout
		driver.get("https://rahulshettyacademy.com/locatorspractice/");		
		//sendkeys is used to send text in the field
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("submit")).click();
		
		// CSS Selector
		
		// Class name -> tagname.classname ->Button.signInBtn
		// Id -> tagname#id -> input#inputUsername  [if there is no class]
		// Tagname[attribute = 'value']	-> Input[placeholder ='Username'][if it does not have id or class]
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
		//no unique attributes
    	driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
		//traversing in xpath from parent to child tags
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		//traversing in css from parent to child
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());	
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Rahul");
		
		//Regular expression CSS
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		
		//Regular expression Xpath
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

		//driver.quit();

	}

}
