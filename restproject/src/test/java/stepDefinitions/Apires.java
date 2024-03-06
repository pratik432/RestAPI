package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import testcase.GoogleApi;

public class Apires{
	static WebDriver driver;
	GoogleApi ga = new GoogleApi();
	
	@Given("User operates the post and get")
	public void user_operates_the_post_and_get() {
		ga.getPostcall();
	}
	@And("User operates put")
	public void user_operates_put() {
		ga.getPutMethod();
	}
}