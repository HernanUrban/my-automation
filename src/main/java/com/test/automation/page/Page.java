package com.test.automation.page;

import org.openqa.selenium.WebElement;

import com.test.automation.exception.PageException;

/**
 * Page interface to be implemented by the application pages.
 * 
 * @author hernan.urban
 * 
 */
public interface Page {

	/**
	 * Retrieves the name of the current page.
	 * 
	 * @return the page name.
	 */
	public String getPageName();

	/**
	 * Validates if the {@link WebElement} is present in the page.
	 * 
	 * @param webElement
	 *            the element to verify if present.
	 * @return true if element is present.
	 * @throws PageException
	 */
	public boolean isElementPresent(WebElement webElement) throws PageException;

}
