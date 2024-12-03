import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class SortingTable_JavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
//		Sort the list by clicking on column 
//		retrive the elements and insert in into List
//		Sort the List of Web Elements which will be your sorted List
//		Compare the Before sorted and after sorted list using assert
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		List<WebElement>  manualWebElements = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<String> manualSortedList  = manualWebElements.stream().map(a->a.getText()).collect(Collectors.toList());
		
		List<String> streamsortedList = manualSortedList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertEquals(manualSortedList ,streamsortedList , " List is not sorted" );
		
		
		List<String> Listprice;
		do {
		
			List<WebElement>  findingpagelist = driver.findElements(By.xpath("//tr/td[1]"));
						

		 Listprice = findingpagelist.stream().filter(a->a.getText().contains("Strawberry")).map(b->getVeggieprice(b))
				.collect(Collectors.toList());
		 
		
		if(Listprice.size()<1) {
			
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			
		}
		
		}
		while(Listprice.size()<1);	
		
		
		Listprice.forEach(s->System.out.println(s));  
		
		
		
		
	}

	private  static String getVeggieprice(WebElement b ) {
		// TODO Auto-generated method stub
		
		String price = b.findElement(By.xpath("following-sibling::td[1]")).getText();
				
		return price;
	}

}
