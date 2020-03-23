package stepDefinitions;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.io.*;

import static org.junit.Assert.assertEquals;


public class pulseDigitalSteps {

    static WebDriver driver;
    public static String selector = "";


//    @Given("I launch chrome browser")
//    public void iLaunchChromeBrowser() throws InterruptedException {
//
//        //The below piece of code to invoke Chromedriver on MAC (provided you have downloaded it, see ReadMe)
//        //Comment out the one you don't need
//        System.setProperty("webdriver.chrome.driver","/Users/saswatochowdhury/Downloads/Installers/chromedriver");
//        driver = new ChromeDriver();
//
//        driver.manage().window().maximize();
////        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
//        driver.get("http://www.google.com/");
//
//    }

    @Given("I navigate to the PwC Digital Pulse website")
    public void iNavigateToThePwCDigitalPulseWebsite() throws InterruptedException {

        //The below piece of code to invoke Chromedriver on MAC (provided you have downloaded it, see ReadMe)
        //Comment out the one you don't need
        System.setProperty("webdriver.chrome.driver","/Users/saswatochowdhury/Downloads/Installers/chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
        driver.get("https://www.digitalpulse.pwc.com.au");
    }



    @When("I am viewing the ‘Home’ page")
    public void iAmViewingTheHomePage() throws  InterruptedException {
        WebElement homePage = driver.findElement(By.xpath("//*[@id=\"menu-main-menu-1\"]/li[1]/a"));
        assertEquals(homePage.getText(), "Home");
        homePage.click();
    }

    @Then("I am presented with a carousel displaying (.+) featured articles")
    public void iAmPresentedWithACarouselDisplayingFeaturedArticles(int numb, String args[]) {
        selector = "li[class^=a-carousel-card]";
//        ArrayList items = (ArrayList) driver.findElements(By.cssSelector("li.flex:nth-child(2)"));
        ArrayList items = (ArrayList) driver.findElements(By.cssSelector(selector));

        ArrayList<String> list1 = new ArrayList<String>();
        String name;

        for(int i=0;i<items;i++) {
            int index = i + 1;

            name = driver.findElement(By.cssSelector(selector + "[" + index + "]")).getText();
            list1.add(name);

        }

    }



    @And("Clicking the ‘Next’ button on the carousel will load the next {int} featured articles")
    public void clickingTheNextButtonOnTheCarouselWillLoadTheNextFeaturedArticles(int arg0) {

        driver.findElement(By.cssSelector("div[class^=a-carousel-col] a")).click();

        ArrayList nextItems = (ArrayList) driver.findElements(By.cssSelector(selector));

        ArrayList list2 = new ArrayList();

        String newName;

        for (int i = 0; i < nextItems; i++) {
            int index = i + 1;

            //This will get the name of each item in carousel
            newName = driver.findElement(By.cssSelector(selector + "[" + index + "]")).getText();
            list2.add(newName);
        }

    }

    @And("Clicking the ‘Previous’ button on the carousel will load the previous {int} featured articles")
    public void clickingThePreviousButtonOnTheCarouselWillLoadThePreviousFeaturedArticles(int arg0) {


        driver.close();
    }

    @When("I click on the ‘Magnifying glass’ icon to perform a search And I enter the text ‘Single page applications’")
    public void iClickOnTheMagnifyingGlassIconToPerformASearchAndIEnterTheTextSinglePageApplications() {
    }

    @And("I submit the search")
    public void iSubmitTheSearch() {
    }

    @Then("I am taken to the search results page")
    public void iAmTakenToTheSearchResultsPage() {
    }

    @And("I am presented with at least {int} search result")
    public void iAmPresentedWithAtLeastSearchResult(int arg0) {

        driver.close();
    }


//    @When("I clicks through to SecurePay website")
//    public void i_clicks_through_to_SecurePay_website() {
//
//        WebElement securePayLink = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3"));
//        securePayLink.click();
//        driver.manage().timeouts().pageLoadTimeout(3,TimeUnit.SECONDS);
//
//    }
//
//    @When("I navigate to (.+) page on SecurePay website")
//    public void i_navigate_to_page_on_SecurePay_website(String contactUs) {
//
//        WebElement contact = driver.findElement(By.xpath("//*[@id=\"menu-item-126\"]/a"));
//        contactUs = contact.getText();
//        assertEquals("Contact Us", contactUs);
//        contact.click();
//
//    }

//    @Then("Contact Us page is successfully loaded")
//    public void contact_Us_page_is_successfully_loaded() {
//        WebElement contactUsPage = driver.findElement(By.id("section-heading"));
//        assertEquals("Contact Us", contactUsPage.getText());
//
//    }
//
//    @Then("I should be able to view and fill up the contact us form")
//    public void i_should_be_able_to_view_and_fill_up_the_contact_us_form() {
//
//        FakeValuesService fakeValuesService = new FakeValuesService(
//                new Locale("en-GB"), new RandomService());
//
//        WebElement FirstName = driver.findElement(By.name("first-name"));
//        String firstName = fakeValuesService.letterify("????##");
//        FirstName.sendKeys(firstName);
//
//        WebElement LastName = driver.findElement(By.name("last-name"));
//        String lastName = fakeValuesService.letterify("????##");
//        LastName.sendKeys(lastName);
//
//        WebElement Email = driver.findElement(By.name("email-address"));
//        String email = fakeValuesService.bothify("????##???###@gmail.com");
//        Email.sendKeys(email);
//
//        WebElement PhoneNumber = driver.findElement(By.name("phone-number"));
//        String phoneNumber = fakeValuesService.numerify("????##??");
//        PhoneNumber.sendKeys(phoneNumber);
//
////        WebElement Website = driver.findElement(By.name("website-url"));
//        WebElement Company = driver.findElement(By.name("business-name"));
//        String companyName = fakeValuesService.letterify("?????####");
//        Company.sendKeys(companyName);
//
//        driver.close();
//
//    }



}
