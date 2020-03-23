package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;


public class pulseDigitalSteps {

    public static WebDriver driver;
    public String selector = "";
    public static WebElement boxSearch;


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
    public static void iClickOnTheMagnifyingGlassIconToPerformASearchAndIEnterTheTextSinglePageApplications() throws ExecutionException{

        WebElement iconSearch = driver.findElement(By.cssSelector("i.btr:nth-child(4)"));
        iconSearch.click();

        boxSearch = driver.findElement(By.id("search-input"));
        boxSearch.sendKeys("Single page applications");
    }

    @And("I submit the search")
    public void iSubmitTheSearch() throws ExecutionException {

        boxSearch.sendKeys(Keys.RETURN);

    }

    @Then("I am taken to the search results page")
    public void iAmTakenToTheSearchResultsPage() throws ExecutionException {
        //Verifying the user is one the search results page

        WebElement resultsPage = driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div/span"));
        resultsPage.getText();
        assertThat(resultsPage.getText(), containsString("search results"));


    }

    @And("I am presented with at least (.+) search result")
    public void iAmPresentedWithAtLeastSearchResult(int items) {

        List searchResults = driver.findElements(By.cssSelector("section.container:nth-child(4) > div:nth-child(1)"));
        items = searchResults.size();
        assertThat(items, greaterThan(1));

        driver.close();
    }

}
