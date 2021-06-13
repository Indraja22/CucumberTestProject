package helperClasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import driverSetupClasses.BrowserFactory;

public class UtilityMethods extends BrowserFactory {

	WebDriver driver = getWebDriver();

	public static String readFromPropFile(String propKey) {
		Properties prop = new Properties();
		try {
			FileReader fr = new FileReader("./src/test/resources/global/config/test-configs.properties");
			prop.load(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop.getProperty(propKey);
	}

	public void launchUrl(String url) {
		driver.get(url);
	}

}
