package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class pulseDigitalSteps {

    public static WebDriver driver;
    public static String selector = "";


    @Given("I navigate to the PwC Digital Pulse website")
    public void iNavigateToThePwCDigitalPulseWebsite() throws InterruptedException {

        //The below piece of code to invoke Chromedriver on MAC
        //Replace the path with your system's chromedriver location

        System.setProperty("webdriver.chrome.driver","/Users/saswatochowdhury/Downloads/Installers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.digitalpulse.pwc.com.au");
    }


    @When("I am viewing the ‘Home’ page")
    public void iAmViewingTheHomePage() {
        //Checks for the Digital Pulse logo and finds out the link for the same and validates with home-page url

        WebElement digitalPulseLogo = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/a[2]"));
        String homePageLink = digitalPulseLogo.getAttribute("href");
        assertEquals("https://www.digitalpulse.pwc.com.au", homePageLink);

    }

    @Then("I am presented with a carousel displaying (.+) featured articles")
    public void iAmPresentedWithACarouselDisplayingFeaturedArticles(int items0) {

        List elements = driver.findElements(By.cssSelector("li.flex:nth-child(2)"));
        List<String> values = new ArrayList<>();
        items0 = elements.size();
        assertEquals(3,items0);



    }

    @And("Clicking the ‘Next’ button on the carousel will load the next (.+) featured articles")
    public void clickingTheNextButtonOnTheCarouselWillLoadTheNextFeaturedArticles(int items1) {

        WebElement caraouselNext = driver.findElement(By.cssSelector(".flex-next"));
        caraouselNext.click();

        List elements = driver.findElements(By.cssSelector("li.flex:nth-child(3)"));
        items1 = elements.size();
        assertEquals(3, items1);

    }

    @And("Clicking the ‘Previous’ button on the carousel will load the previous (.+) featured articles")
    public void clickingThePreviousButtonOnTheCarouselWillLoadThePreviousFeaturedArticles(int items2) {

        WebElement carouselPrevious = driver.findElement(By.cssSelector(".flex-prev"));
        carouselPrevious.click();

        List elements = driver.findElements(By.cssSelector("li.flex:nth-child(2)"));
        items2 = elements.size();
        assertEquals(3, items2);





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
