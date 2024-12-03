import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDownPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Assert.assertFalse(driver.findElement(By.cssSelector("[id*='SeniorCitizenDiscount']")).isSelected());
		
		System.out.println(driver.findElement(By.cssSelector("[id*='SeniorCitizenDiscount']")).isSelected());// returns false because checkbox is not selected
		driver.findElement(By.cssSelector("[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("[id*='SeniorCitizenDiscount']")).isSelected());// returns true once checkbox is selected
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());// counts number of checkboxes

		Assert.assertTrue(driver.findElement(By.cssSelector("[id*='SeniorCitizenDiscount']")).isSelected());
		
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
//		int i=1;
//		while(i<8) {
//			
//		driver.findElement(By.id("hrefIncAdt")).click();
//		i++;
//		}

		for (int i = 1; i < 8; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "8 Adult");
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
 //   	driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

		// Parent Child Relationship xpath

		// //div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']

//		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@text='Pune (PNQ)']")).click();

		Thread.sleep(2000);
		// xpath - //a[@class='ui-state-default ui-state-highlight']
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
				
		
		
		WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select currency = new Select(staticdropdown);
		currency.selectByVisibleText("AED");
		System.out.println(currency.getFirstSelectedOption().getText());
		
		
		driver.findElements(By.xpath("//input[@name='ctl00$mainContent$rbtnl_Trip']")).size();
		
	    System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
//		driver.findElement(By.id("Div1")).getAttribute("style").contains("1");
	    driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("it's enabled");
			Assert.assertTrue(true);
			
		}
		else {
           driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5");
			System.out.println("it's disabled");
			Assert.assertFalse(false);
			
		}
		
	}

}
