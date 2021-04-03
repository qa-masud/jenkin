package ups.nj.stefdef;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.CommonUtility;
import cucumber.api.java.en.*;
import ups.nj.supperpage.CucumberBaseClass;
import zoopla.pagefactory.elements.ZooplaLoginPage;

public class LoginStepDef extends CucumberBaseClass {
	ZooplaLoginPage pf;

	@Given("^User can open any browser$")
	public void user_can_open_any_browser() {
		setUP();
		//pf = new ZooplaLoginPage(driver);
		 pf = PageFactory.initElements(driver, ZooplaLoginPage.class);
	}

	@Given("^User able to enter \"([^\"]*)\" url$")
	public void user_able_to_enter_url(String url) {
		driver.get(url);

	}

	@When("^User able to click on the login button$")
	public void user_able_to_click_on_the_login_button() {
		CommonUtility.getExplicitWait(pf.getAcceptCookies(), driver, 30);
		pf.getAcceptCookies().click();

		CommonUtility.getExplicitWait(pf.getClickingSigninBTN(), driver, 300);
		pf.getClickingSigninBTN().click();
	}

	
	// this on first run
	@When("^User enter the userName \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_enter_the_userName_and_password(String userName, String pwd) {
		pf.getsendUserName().sendKeys(userName);
		pf.getPwd().sendKeys(pwd);

	}
   // This one is 2nd
	@When("^User click on the signing button$")
	public void user_click_on_the_signing_button() {
		pf.getPwd().submit();

	}

	@Then("^User able to verify successfully login & verify the homepage title$")
	public void user_able_to_verify_successfully_login_verify_the_homepage_title() {
		String expected = "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents";
		 Assert.assertEquals(expected, driver.getTitle());
		System.out.println(expected);

	   //driver.close();  // Only close the browser
		driver.quit();    // Close the browser as well as server
		
		// IE browser what kind of challenge you get it & How resolved it

	}

	// Scenario Outline
	@When("^User can enter the user name  \"([^\"]*)\"$")
	public void user_can_enter_the_user_name(String userName) {
		pf.getsendUserName().sendKeys(userName);

	}

	@When("^User can  enter the pwd \"([^\"]*)\"$")
	public void user_can_enter_the_pwd(String passWord) {
		pf.getPwd().sendKeys(passWord);
	}

	// Background: feature dynamic element to handle by collection
	@Given("^User able to  enter location as  \"([^\"]*)\" in text box$")
	public void user_able_to_enter_location_as_in_text_box(String location) {
		pf.getSearchLocation().sendKeys(location);
		pf.getSearchLocation().sendKeys(Keys.ENTER);

	}

	@When("^User able to print  all property value/price in consule$")
	public void user_able_to_print_all_property_value_price_in_consule() {
	}

	@When("^User able to click on the thard property$")
	public void user_able_to_click_on_the_thard_property() {
	}

	@Then("^Verify the price of the property$")
	public void verify_the_price_of_the_property() {
	}

}