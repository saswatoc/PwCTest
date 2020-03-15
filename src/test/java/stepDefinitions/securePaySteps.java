package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class securePaySteps {

    WebDriver driver;

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Given("I open (.+) webpage")
    public void i_open_webpage(String string) {
        driver.get("https://www.google.com/");
    }

    @When("I search for SecurePay website")
    public void i_search_for_SecurePay_website() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I click navigate to {string} page on SecurePay website")
    public void i_click_navigate_to_page_on_SecurePay_website(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Contact Us page is successfully loaded")
    public void contact_Us_page_is_successfully_loaded() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
