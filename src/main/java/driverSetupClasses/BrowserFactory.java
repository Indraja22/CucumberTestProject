package driverSetupClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import helperClasses.UtilityMethods;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public WebDriver driver;
	public ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	UtilityMethods um;

	public WebDriver init_webDriver() {

		String browser = um.readFromPropFile("browserName");

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
			break;
			
		default:
			System.out.println("Enter a valid browserName!");
			
		}

		getWebDriver().manage().deleteAllCookies();
		getWebDriver().manage().window().maximize();
		return getWebDriver();

	}

	public synchronized WebDriver getWebDriver() {
		return tlDriver.get();
	}

}
