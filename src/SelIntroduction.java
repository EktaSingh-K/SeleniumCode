import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {

		// Invoking Browser
		// step to invoke chrome driver //
		// Selenium Manager
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		// Firefox launch
		// geckodriver

//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dell\\Downloads\\geckodriver-v0.35.0-win64\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
//
//		System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
//
//		driver.get("https://rahulshettyacademy.com");
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getCurrentUrl());
//      
//		System.out.println("Hi I am Ekta");
//		driver.close();
//		driver.quit();

		
		
	}

}
