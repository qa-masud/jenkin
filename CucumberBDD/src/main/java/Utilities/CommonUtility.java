package Utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ups.nj.supperpage.CucumberBaseClass;

public class CommonUtility extends CucumberBaseClass {

	public static void jsClick(WebElement elm) {
		JavascriptExecutor excuter = (JavascriptExecutor) driver;
		excuter.executeScript("arguments[0].click();", elm);
	}

	public static void acctionClick(WebElement ele) {
		Actions action = new Actions(driver);
		action.click(ele).build().perform();

	}

	public static WebElement getExplicitWait(WebElement elem, WebDriver driver, long time) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elem));
		return element;

	}

}