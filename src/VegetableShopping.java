import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VegetableShopping {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		String[] names = {"Brocolli" , "Cauliflower", "Cucumber"};		
		additems(driver,names);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));

		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
		
		
	}
	
	public static void additems(WebDriver driver,String[] names) throws InterruptedException {
		
		int j=0;
		Thread.sleep(3000);
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i = 0; i <products.size();i++) {
			
			List arrayList = Arrays.asList(names);
			
			String vegetable = products.get(i).getText();
			String[] splittedname = vegetable.split("-");
			String formattedname = splittedname[0].trim();
			
			if(arrayList.contains(formattedname)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==names.length) {
				System.out.println("Vegetable added to Cart");
				break;
				}
			}
		}
		
	}

}
