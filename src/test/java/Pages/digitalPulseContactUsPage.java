package Pages;

//This page contains elements from Pwc Digital Pulse's 'Contact Us' page, by navigating
//through RHS-Menu

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class digitalPulseContactUsPage {

    private static WebElement element = null;
    WebDriver driver;


    public static WebElement contactUs_PageHeader(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div"));
        return element;
    }

    public static WebElement contactUs_DigitalServices(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div[1]/p[2]/a"));
        return element;
    }

    public static WebElement contactUs_EditorialTeam(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div[2]/p"));
        return element;
    }

    public static WebElement contactUs_Careers(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div[3]/p[2]/a"));
        return element;
    }

    public static WebElement contactUs_GeneralEnquiries(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div[4]/p[2]/a"));
        return element;
    }
}
