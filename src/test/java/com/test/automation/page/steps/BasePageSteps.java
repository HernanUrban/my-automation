package com.test.automation.page.steps;

import static com.test.automation.util.Constants.APPLICATION_BASE_URL_KEY;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.test.automation.driver.DriverProvider;
import com.test.automation.util.PropertiesUtil;

/**
 * Base steps for the application pages.
 * 
 * @author hernan.urban
 * 
 */
@ContextConfiguration(locations = { "classpath:/configuration/cucumber.xml" })
public class BasePageSteps {

	/**
	 * Selenium based driver.
	 */
	private WebDriver driver;

	@Autowired
	private DriverProvider driverProvider;

	@Autowired
	PropertiesUtil propertiesUtil;

	/**
	 * Set Up.
	 */
	public final void baseSetup() {
		driver = driverProvider.getDriver();
	}

	/**
	 * Get the given URL.
	 * 
	 * @param url
	 *            the URL to access.
	 */
	public void go(String url) {
		driver.get(url);
	}

	/**
	 * Retrieves the base application URL.
	 * 
	 * @return The application URL.
	 */
	public String getBaseUrl() {
		return propertiesUtil.getProperty(APPLICATION_BASE_URL_KEY);
	}

	/**
	 * Sets the page timeout in seconds
	 * 
	 * @param secs
	 *            The timeout time
	 */
	public void setPageTimeout(int secs) {
		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
	}

	/**
	 * Maximizes the page window.
	 */
	public void maximizePage() {
		driver.manage().window().maximize();
	}

	/**
	 * Deletes all cookies.
	 * 
	 * @throws InterruptedException
	 */
	public void clearBrowserCache() throws InterruptedException {
		driver.manage().deleteAllCookies();
		Thread.sleep(2000); // wait 2 seconds to clear cookies.
	}

	/**
	 * Tear down.
	 */
	public final void baseTeardown() {
		try {
			clearBrowserCache();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
