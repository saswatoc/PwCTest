package stepDefinitions;

import Pages.digitalPulseContactUsPage;
import Pages.digitalPulseHomePage;
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
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;


public class pulseDigitalSteps {

    public static WebDriver driver;
    public String selector = "";
    public static WebElement boxSearch;


    @Given("I navigate to the PwC Digital Pulse website")
    public void iNavigateToThePwCDigitalPulseWebsite() throws InterruptedException {

        //The below piece of code invokes Chromedriver on MAC
        //Replace the path with your system's chromedriver location

        System.setProperty("webdriver.chrome.driver", "/Users/saswatochowdhury/Downloads/Installers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.digitalpulse.pwc.com.au");
    }


    @When("I am viewing the ‘Home’ page")
    public void iAmViewingTheHomePage() {
        //Checks for the Digital Pulse logo and finds out the link for the same and validates with home-page url


        String homePageLink = digitalPulseHomePage.homePage_DigitalPulseLogo(driver).getAttribute("href");
        assertEquals("https://www.digitalpulse.pwc.com.au", homePageLink);

    }

    @Then("I am presented with a carousel displaying (.+) featured articles")
    public void iAmPresentedWithACarouselDisplayingFeaturedArticles(int items0) {

        List<WebElement> elements = driver.findElements(By.cssSelector("li.flex:nth-child(2)"));
        List<String> values = new ArrayList<>();
        items0 = elements.size();
        assertEquals(3, items0);


    }

    @And("Clicking the ‘Next’ button on the carousel will load the next (.+) featured articles")
    public void clickingTheNextButtonOnTheCarouselWillLoadTheNextFeaturedArticles(int items1) {

        digitalPulseHomePage.homePage_CarouselNext(driver).click();

        List elements = driver.findElements(By.cssSelector("li.flex:nth-child(3)"));
        items1 = elements.size();
        assertEquals(3, items1);

    }

    @And("Clicking the ‘Previous’ button on the carousel will load the previous (.+) featured articles")
    public void clickingThePreviousButtonOnTheCarouselWillLoadThePreviousFeaturedArticles(int items2) {

        digitalPulseHomePage.homePage_CarouselPrevious(driver).click();

        List elements = driver.findElements(By.cssSelector("li.flex:nth-child(2)"));
        items2 = elements.size();
        assertEquals(3, items2);
        driver.close();
    }

    @When("I click on the ‘Magnifying glass’ icon to perform a search And I enter the text ‘Single page applications’")
    public static void iClickOnTheMagnifyingGlassIconToPerformASearchAndIEnterTheTextSinglePageApplications() throws ExecutionException {

        digitalPulseHomePage.homePage_SearchIcon(driver).click();

        digitalPulseHomePage.homePage_SearchBox(driver).sendKeys("Single page applications");
    }

    @And("I submit the search")
    public void iSubmitTheSearch() throws ExecutionException {

        digitalPulseHomePage.homePage_SearchBox(driver).sendKeys(Keys.RETURN);

    }

    @Then("I am taken to the search results page")
    public void iAmTakenToTheSearchResultsPage() throws ExecutionException {
        //Verifying the user is one the search results page

        String resultsTxt = digitalPulseHomePage.homePage_SearchResultsPg(driver).getText();
        assertThat(resultsTxt, containsString("search results"));


    }

    @And("I am presented with at least (.*) search result")
    public void iAmPresentedWithAtLeastSearchResult() throws ExecutionException{

        int i =1;
        List<WebElement> searchResults = driver.findElements(By.cssSelector("section.container:nth-child(4) > div:nth-child(1)"));
        int itemCount = searchResults.size();
        assertEquals(i,itemCount);

        driver.quit();
    }

    @When("I select ‘Contact us’ from the hamburger menu")
    public void iSelectContactUsFromTheHamburgerMenu() throws ExecutionException {
        digitalPulseHomePage.hamburger_MenuLink(driver).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        digitalPulseHomePage.hamburger_ContactUs_Link(driver).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }


    @Then("I am taken to the ‘Contact us’ page")
    public void iAmTakenToTheContactUsPage() throws ExecutionException {

        digitalPulseContactUsPage.contactUs_PageHeader(driver).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String headerText = digitalPulseContactUsPage.contactUs_PageHeader(driver).getText();
        assertTrue(headerText.equalsIgnoreCase("Contact Us"));
    }


    @And("I am presented with the below options for contacts with (.+) and (.+)")
    public void iAmPresentedWithTheBelowOptionsForContactsWithHeadingAndContactLink(String Heading, String Link) throws ExecutionException{


        if(Heading == "PwC Digital Services") {
            digitalPulseContactUsPage.contactUs_DigitalServices(driver).click();
            String url = digitalPulseContactUsPage.contactUs_DigitalServices(driver).getAttribute("href");
            assertEquals(Link, url);
        }
           else if(Heading=="Digital Pulse editorial team"){
               digitalPulseContactUsPage.contactUs_EditorialTeam(driver).click();
               String url = digitalPulseContactUsPage.contactUs_EditorialTeam(driver).getAttribute("href");
               assertNull(url);
            }
           else if(Heading=="Careers at PwC"){
               digitalPulseContactUsPage.contactUs_Careers(driver).click();
               String url = digitalPulseContactUsPage.contactUs_Careers(driver).getAttribute("href");
               assertEquals(Link, url);
           }
           else if(Heading=="General enquiries"){
               digitalPulseContactUsPage.contactUs_GeneralEnquiries(driver).click();
               String url = digitalPulseContactUsPage.contactUs_GeneralEnquiries(driver).getAttribute("href");
               assertEquals(Link, url);
        }
        driver.close();
        driver.quit();
    }
}
