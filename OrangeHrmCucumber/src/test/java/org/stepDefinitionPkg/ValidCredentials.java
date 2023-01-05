package org.stepDefinitionPkg;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidCredentials {

	@Rule
	public ErrorCollector error;
	WebDriver driver;

	@Given("User is on loginpage")
	public void user_is_on_loginpage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		error = new ErrorCollector();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		try {
			Assert.assertEquals(actualUrl, expectedUrl);

		} catch (Throwable e) {
			error.addError(e);
		}
	}

	@When("user enters valid credentials")
	public void user_enters_valid_credentials(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
		Map<String, String> map = list.get(0);
		String userName = map.get("Username");
		String passWord = map.get("Password");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passWord);

	}

	@When("user clicks login")
	public void user_clicks_login() {
		driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']//button")).click();

	}

	@Then("user should see homepage")
	public void user_should_see_homepage() {
		String ExpectedHomePageUrl = driver.getCurrentUrl();
		String actualHomePageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(actualHomePageUrl, ExpectedHomePageUrl);
		driver.close();
	}

}
