import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Scroll {
	public static void main(String[] args) throws InterruptedException, NumberFormatException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		int sum =0 ;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop = 500"); 
        //To find height of the page --> console.log(document.body.scrollHeight);
        
        List<WebElement> Listofnumbers = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
        
        for(int i=0; i<Listofnumbers.size();i++) {
        	
        	System.out.println(Listofnumbers.get(i).getText());
        	
        	 sum = sum + Integer.parseInt(Listofnumbers.get(i).getText());
        	 
        }

 
		System.out.println(sum);
		String total = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();   	 
   	    Assert.assertEquals(sum,Integer.parseInt(total) ," Sum is not equal to Total" );
	     
	}

}
