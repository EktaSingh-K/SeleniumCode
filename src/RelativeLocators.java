import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameField = driver.findElement(By.cssSelector("[name='name']"));
		
		System.out.println( driver.findElement(with(By.tagName("label")).above(nameField)).getText());
		
		WebElement dateofbirthtext = driver.findElement(By.cssSelector("[for='dateofBirth'] "));
		
		driver.findElement(with(By.tagName("input")).below(dateofbirthtext)).click();
		
		WebElement text = driver.findElement(By.cssSelector("[for='exampleCheck1']"));
		
		driver.findElement(with(By.tagName("input")).toLeftOf(text)).click();
		
		WebElement radiobtn = driver.findElement(By.id("inlineRadio1"));
		
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radiobtn)).getText());
	}

}
