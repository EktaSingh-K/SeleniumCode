import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.devtools.v127.preload.model.PrefetchStatus;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EdgeOptions option = new EdgeOptions();
        option.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.edge.driver", "C:\\Users\\dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress::4444");
		option.setCapability("Proxy", proxy);
		
		Map<String,Object> pref = new HashMap<String,Object>();
		pref.put("download.default_directory", "/directory/path");
		option.setExperimentalOption("prefs", pref);
		
		WebDriver driver = new EdgeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		System.out.print(driver.getTitle());
		
	}

}
