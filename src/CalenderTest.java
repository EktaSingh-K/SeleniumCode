import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class CalenderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String month = "1";
		String Day = "16";
		String Year = "2024";
		String[] Expectdlist = { month , Day , Year };
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup__input.react-date-picker__inputGroup__year")).click();
		driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector("button.react-calendar__tile--hasActive.react-calendar__decade-view__years__year")).click();
		driver.findElements(By.cssSelector("button.react-calendar__tile.react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//*[text()='"+Day+"']")).click();
		
		 List<WebElement> Listofdate = driver.findElements(By.cssSelector("input.react-date-picker__inputGroup__input"));
		
		 for(int i =0; i<Listofdate.size() ;i++) {
			 
		     String Actuallist = driver.findElements(By.cssSelector("input.react-date-picker__inputGroup__input")).get(i).getAttribute("value");
		     
		     Assert.assertEquals(Actuallist, Expectdlist[i]);
			 System.out.println(Actuallist);
		 }
		
		
	}
	
}	
		
