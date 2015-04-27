package com.test.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Web Driver Factory based on Selenium.
 * 
 * @author hernan.urban
 * 
 */
public final class WebDriverFactory {

	/**
	 * Web driver builder.
	 * 
	 * @param driverType
	 *            the driver type.
	 * @return a Selenium Web Driver instance.
	 */
	public static WebDriver buildDriver(DriverType driverType) {
		WebDriver driver = null;
		switch (driverType) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case CHROME:
			driver = new ChromeDriver();
			break;
		case IE:
			driver = new InternetExplorerDriver();
			break;
		case SAFARI:
			driver = new SafariDriver();
			break;
		case OPERA:
			driver = new OperaDriver();
		case UNKNOWN:
		default:
			driver = new HtmlUnitDriver();
			break;

		}
		return driver;
	}

}
