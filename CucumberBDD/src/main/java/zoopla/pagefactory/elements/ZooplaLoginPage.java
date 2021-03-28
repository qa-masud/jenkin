package zoopla.pagefactory.elements;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ups.nj.supperpage.CucumberBaseClass;

public class ZooplaLoginPage extends CucumberBaseClass {

	public ZooplaLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[text()='Sign in'])[1]") 
	@CacheLookup
	private WebElement clickingSigninBTN;

	public WebElement getClickingSigninBTN() {
		return clickingSigninBTN;
	}

	@FindBy(xpath = "(//*[text()='Accept all cookies'])[2]")
	@CacheLookup
	private WebElement acceptCookies;

	public WebElement getAcceptCookies() {
		return acceptCookies;
	}
	
	
	@FindBy(id = "signin_email")
	@CacheLookup
	private WebElement sendUserName;

	public WebElement getsendUserName() {
		return sendUserName;
	}

	
	@FindBy(id = "signin_password")
	@CacheLookup
	private WebElement sendPwd;

	public WebElement getPwd() {
		return sendPwd;
	}
	
	@FindBy(name = "q")
	@CacheLookup
	private WebElement searchLocation;

	public WebElement getSearchLocation() {
		return searchLocation;
	}


	
	// (//*[text()='Accept all cookies'])[2]
	// *[@id='ui-cookie-consent-overlay-wrap']/descendant::button[2]
}
