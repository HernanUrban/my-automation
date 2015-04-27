package com.test.automation.driver;

import static com.test.automation.driver.DriverType.FIREFOX;
import static com.test.automation.util.Constants.BROWSER_TYPE_KEY;

import javax.annotation.PreDestroy;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import com.test.automation.util.PropertiesUtil;

/**
 * Singleton class that provides the web driver based on the configuration
 * properties.
 * 
 * @author hernan.urban
 * 
 */
public class DriverProvider {

	private WebDriver driver;
	private DriverType driverType = FIREFOX;

	/**
	 * Parameterized constructor.
	 * 
	 * @param propertiesUtil
	 *            the properties provider.
	 */
	private DriverProvider(PropertiesUtil propertiesUtil) {
		String browser = propertiesUtil.getProperty(BROWSER_TYPE_KEY,
				FIREFOX.getName());
		if (StringUtils.isNotBlank(browser)) {
			this.driverType = DriverType.fromValue(browser);
		}
		this.driver = WebDriverFactory.buildDriver(driverType);
	}

	/**
	 * Retrieves the Selenium web driver.
	 * 
	 * @return the web driver.
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * Retrieves the web driver type.
	 * 
	 * @return the driver type.
	 */
	public DriverType getDriverType() {
		return driverType;
	}

	@PreDestroy
	public void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
}
