package com.test.automation.page.google;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.page.BasePage;

/**
 * Example page to perform a search in google.
 * 
 * @author hernan.urban
 * 
 */
public class GooglePage extends BasePage {

	private static final String PAGE_NAME = "Google search page";

	// -------- Attributes ----------
	@FindBy(how = How.NAME, using = "q")
	private WebElement searchField;

	@FindBy(how = How.XPATH, using = "//*[contains(@class, 'teaser-list')]/li/article/div[2]/h3")
	private List<WebElement> allSearchResults;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"rso\"]/div[2]/li[1]/div/h3/a")
	private WebElement firstResultElement;

	public GooglePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void fillSearchField(String text) {
		if (searchField.isDisplayed()) {
			this.searchField.sendKeys(text);
		}
	}

	public void submitSearch() {
		if (searchField.isDisplayed()) {
			searchField.submit();
		}
	}

	public boolean validatesResults() {
		return (allSearchResults != null && allSearchResults.isEmpty());

	}
	
	public boolean verifyFirstElement(String text){
		return firstResultElement.getText().contains(text);
	}

	@Override
	public String getPageName() {
		return PAGE_NAME;
	}

}
