import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2E {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@text='Kolkata (CCU)']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@text='Pune (PNQ)']")).click();
		Thread.sleep(1000);
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
       
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("it's enabled");
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']")).click();
		}else {
			Assert.assertFalse(false);
		}
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		for (int i = 1; i < 2; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "2 Adult");
        
        WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select currency = new Select(staticdropdown);
		currency.selectByVisibleText("AED");
		System.out.println(currency.getFirstSelectedOption().getText());
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();		
	}

}
