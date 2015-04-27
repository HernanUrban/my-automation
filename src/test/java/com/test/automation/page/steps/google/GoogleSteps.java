package com.test.automation.page.steps.google;

import static org.junit.Assert.assertTrue;

import com.test.automation.page.google.GooglePage;
import com.test.automation.page.steps.BasePageSteps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Cucumber steps to test a search in the Google Page.
 * 
 * @author hernan.urban
 * 
 */
public class GoogleSteps extends BasePageSteps {

	private GooglePage page;

	@Before
	public void setup() {
		super.baseSetup();
		setPageTimeout(30);
		maximizePage();
		page = new GooglePage(getDriver());
	}

	@Given("me in the Google search page")
	public void accessToLoginPage() {
		go(getBaseUrl());
	}

	@When("I enter \"(.*?)\" into search field")
	public void fillTextToSearch(String text) {
		page.fillSearchField(text);
	}

	@When("click on search button")
	public void performSearch() {
		page.submitSearch();
	}

	@Then("the user should see at least a wikipedia link in the result")
	public void findAtLeastAResult() {
		assertTrue(page.validatesResults());
	}

	@Then("verify first link text \"([^\"]*)\"")
	public void verifyFirstElementTest(String text) {
		assertTrue(page.verifyFirstElement(text));
	}

	@After
	public void tearDown() {
		super.baseTeardown();
	}
}
