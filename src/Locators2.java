import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "rahul";
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // implicit wait -- 5 seconds timeout This
																			// takes places when tagname doesnot
																			// apear/exist so it waits.
		String PASS = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		// sendkeys is used to send text in the field
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(PASS);
		driver.findElement(By.className("submit")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		driver.findElement(By.xpath("//div/h2")).getText();

		Assert.assertEquals(driver.findElement(By.xpath("//div/h2")).getText(), "Hello " + name + ",");
		// css selector traversing
		driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		driver.findElement(By.xpath("//*[text()='Log Out']")).click(); // //button[text()='Log Out']

		driver.close();
	}

	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		// Please use temporary password 'rahulshettyacademy' to Login.
		String[] password1 = passwordText.split("'");
		// 0th index = Please use temporary password
		// 1th index = rahulshettyacademy' to Login.
		String[] Finalpassword = password1[1].split("'");
		// 0th index = rahulshettyacademy
		// 1st index = to Login.
        String passwrd = Finalpassword[0];
        return passwrd;
	}

}
