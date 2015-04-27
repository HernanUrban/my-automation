package com.test.automation.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.automation.exception.PageException;

/**
 * Abstract Page which is extended by every application pages.
 * 
 * @author hernan.urban
 * 
 */
public abstract class BasePage implements Page {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public boolean isElementPresent(WebElement webElement) throws PageException {
		try {
			webElement.getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		} catch (Exception e) {
			throw new PageException(e.getMessage());
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
