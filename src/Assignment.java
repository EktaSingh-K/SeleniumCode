import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "bandhan";
		System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();
		String textofBox = driver.switchTo().alert().getText();
		
		String[] leftindex = textofBox.split(",");
		//0th Index - Hello e
		//1st  share this practice page and share your knowledge
		String[] name1 = leftindex[0].split(" ");
		
		//oth - Hello
		//1st - e
		if(name1[1].contains(name)) {
			System.out.println(name);
			driver.switchTo().alert().accept();
			
		}
		else {
			Assert.assertFalse(false);
		}
		
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("confirmbtn")).click();
		String textbox1 = driver.switchTo().alert().getText();
		
		if(textbox1.contains(name)) {
			Assert.assertTrue(true);
			System.out.println("Fucku");
			driver.switchTo().alert().dismiss();
		}else {
			Assert.assertFalse(false);
		}
	}

}
