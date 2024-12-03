import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Brokenlinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//li[@class='gf-li']//a"));
		SoftAssert a = new SoftAssert();
		
		for(WebElement link : allLinks) {
			String at = link.getAttribute("href");
//			@SuppressWarnings("deprecation")
			HttpURLConnection cnc = (HttpURLConnection)new URL(at).openConnection();
			cnc.setRequestMethod("HEAD");
			cnc.connect();
			int  code = cnc.getResponseCode();
			
			a.assertTrue(code<400," The broken link is "+link.getText()+ " and the Code is " +code  );
//			    Google.com  = 400    - messageprint 400<=400 --true 400<400--false
//			    Facebook.com = 399 - no messageprint
//				gmail.com = 401 - messageprint
			System.out.println(code);	
		}
		a.assertAll();
		
//		String singlelink = driver.findElement(By.xpath("//a[contains(@href,'soapui')]")).getAttribute("href");
				// //li[@class='gf-li']//a
//		@SuppressWarnings("deprecation")
		
		
		
	}

}
