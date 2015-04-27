package com.test.automation;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Smoke Test Runner. Executes all tests annotated with specific tags.
 * 
 * @author hernan.urban
 * 
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "html:target/reports/test-report", "json:target/reports/cucumber-report.json" }, features = "src/test/resources", tags = "@SmokeTest", glue = { "com.test.automation.page.steps" })
public class SmokeTestRunnerTest {

}
