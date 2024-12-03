import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Autosuggestive {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("autosuggest")).sendKeys("Fr");
		Thread.sleep(2000);
		List<WebElement> countrylist = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
		//enhanced for loop
		for(WebElement option: countrylist) {
			
			if(option.getText().equalsIgnoreCase("French Guiana")) {
				
				option.click();
				System.out.println("French Guiana COUNTRY is Selected");
				break;
			}
//			System.out.println("French Guiana COUNTRY is selected");

		}
		System.out.println("French Guiana COUNTRY is selected");

		driver.quit();
	}

}
