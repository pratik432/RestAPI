package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			features = "C:\\Users\\Prati\\eclipse-workspace\\restproject\\src\\test\\java\\features\\cs3.feature", 
			glue={"StepDefinitions"},
			tags="@Smoke",
			plugin = {"pretty",
					"html:target/cucumber-reports/cucumber.html",
					"json:target/cucumber-reports/cucumber.json"}		
			)

public class TestRunner extends AbstractTestNGCucumberTests {
}
