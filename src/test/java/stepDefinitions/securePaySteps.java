package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class securePaySteps {

    WebDriver driver;

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() throws InterruptedException {

        //The below piece of code to invoke Chromedriver on Windows PC (provided you have downloaded it, see ReadMe)
//        System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
//        driver=new ChromeDriver();

        //The below piece of code to invoke Chromedriver on MAC (provided you have downloaded it, see ReadMe)
        //Comment out the one you don't need
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);

    }

    @Given("I open (.+) webpage and search for SecurePay")
    public void i_open_google_com_webpage_and_search_for_SecurePay() {
        driver.get("http://www.google.com/");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("SecurePay");
        element.submit();

    }

    @When("I clicks through to SecurePay website")
    public void i_clicks_through_to_SecurePay_website() {

        WebElement securePayLink = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3"));
        securePayLink.click();
        driver.manage().timeouts().pageLoadTimeout(3,TimeUnit.SECONDS);

    }

    @When("I navigate to (.+) page on SecurePay website")
    public void i_navigate_to_page_on_SecurePay_website(String string) {

    }

    @Then("Contact Us page is successfully loaded")
    public void contact_Us_page_is_successfully_loaded() {

    }

    @Then("I should be able to view and fill up the contact us form")
    public void i_should_be_able_to_view_and_fill_up_the_contact_us_form() {

    }


}
