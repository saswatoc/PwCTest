package Pages;
//This page contains elements from Pwc Digital Pulse's 'Home' page

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class digitalPulseHomePage {

    private static WebElement element = null;
    WebDriver driver;

    //Home menu in footer
    WebElement menuHome = driver.findElement(By.xpath("//*[@id=\"menu-main-menu-1\"]/li[1]/a"));
    String text_menuHome = menuHome.getText();


    public static WebElement homePage_DigitalPulseLogo(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/a[2]"));
        return element;
    }

    public static WebElement homePage_SearchIcon(WebDriver driver) {
        element = driver.findElement(By.cssSelector("i.btr:nth-child(4)"));
        return element;
    }

    public static WebElement homePage_SearchResultsPg(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div/span"));
        return element;
    }

    public static WebElement homePage_SearchBox(WebDriver driver) {
        element = driver.findElement(By.id("search-input"));
        return element;
    }

    public static WebElement homePage_CarouselNext(WebDriver driver) {
        element = driver.findElement(By.cssSelector(".flex-next"));
        return element;
    }

    public static WebElement homePage_CarouselPrevious(WebDriver driver) {
        element = driver.findElement(By.cssSelector(".flex-prev"));
        return element;
    }

    public static WebElement hamburger_MenuLink(WebDriver driver) {
        element = driver.findElement(By.cssSelector("i.btr:nth-child(3)"));
        return element;
    }

    public static WebElement hamburger_ContactUs_Link(WebDriver driver) {
        element = driver.findElement(By.cssSelector("#menu-item-65 > a:nth-child(1)"));
        return element;
    }

}
