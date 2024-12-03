import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		
		Actions a = new Actions(driver);
//		a.moveToElement(driver.findElement(By.id("draggable"))).build().perform();
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));

		a.dragAndDrop(drag, drop).build().perform();
		driver.switchTo().defaultContent();
		
		System.out.println(driver.findElement(By.cssSelector("div.demo-list h2")).getText());
		
		
	}

}
