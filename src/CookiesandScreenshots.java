import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.apache.commons.io.FileUtils;

public class CookiesandScreenshots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
//		driver.manage().deleteCookieNamed("cgil");
		
		
		driver.get("https://www.google.com");
		String gmailtext = driver.findElement(By.xpath("//a[text()='Gmail']")).getText();
			
		
//		Assert.assertEquals(gmailtext, "gmaiL");

		if(gmailtext.equals("g-mail")) {
			
			System.out.println("Testcase passed!");
		}
		else {
			
			TakeScreenshot(driver);
			System.out.println("Testcase Faled!");

		}
	

		
	}

	   public static void TakeScreenshot(WebDriver driver) throws IOException {
		   String Timestamp = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss").format(new Date());
		   
		   File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(source ,new File("F:\\SeleniumErrorScreenshots\\" +Timestamp+ ".png" ));
		  		
		   
	   }
}