package ups.nj.supperpage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CucumberBaseClass {
	public static Properties prop;
	public static WebDriver driver;
/*
	public CucumberBaseClass() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/Users/mohammedalam/eclipse-workspace/CucumberBDD/src/main/resources/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}  */
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		

	/*	String browser = prop.getProperty("BrowserType");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		} else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} */
	}

}
