package stepDefs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import driverSetupClasses.BrowserFactory;
import helperClasses.UtilityMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage_stepDef {

	BrowserFactory bf = new BrowserFactory();
	WebDriver driver;
	String title;
	UtilityMethods um;

	@Before
	public void init() {
		driver = bf.init_webDriver();
		um = new UtilityMethods();
	}

	@After
	public void tearDown() {
		try {
			Thread.sleep(6000);
			if (driver != null)
				driver.quit();
			else {
				System.out.println("Driver is already closed!");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	@Given("Open the browser and launch the app url")
	public void open_the_browser_and_launch_the_app_url() {
		driver.get(um.readFromPropFile("url"));
	}

	@When("User is on the HomePage")
	public void user_is_on_the_home_page() {
		title = driver.getTitle();
		System.out.println(title);
	}

	@Then("Verify the title is {string}")
	public void verify_the_title_is(String expectedTitle) {
		Assert.assertTrue(title.contains(expectedTitle));
	}

	@Then("Verify the count of links present on the homepage is {string}")
	public void verify_the_count_of_links_present_on_the_homepage_is(String noOfLinks) {

		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		
		int actInt = linksList.size();
		int expInt = Integer.valueOf(noOfLinks);
		Assert.assertEquals(actInt, expInt);

	}

}
