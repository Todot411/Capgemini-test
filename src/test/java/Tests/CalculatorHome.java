package Tests;

import Pages.CalculatorHomePage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CalculatorHome {

    public static WebDriver driver = new ChromeDriver();
    private CalculatorHomePage homepage = new CalculatorHomePage(driver);
    private WebElement element;


    @Before
    public void individualSetUp(){
        homepage.goHome();
    }

    /** Enter no details and attempt to continue
     * Pre-conditions - none
     * Click continue
     * Verify cannot continue
     */
    @Test
    public void noDetails(){
        homepage.clickContinue();
        List<WebElement> webElementList = driver.findElements(By.cssSelector("div.govuk-error-summary a"));
        Assert.assertTrue(homepage.elementErrorContains(webElementList.get(0),"#amount") && homepage.elementErrorContains(webElementList.get(1),"#period"));
    }

    /**
     * Select frequency then continue, without inputting pay
     */
    @Test
    public void selectOnlyFrequency() {
        homepage.selectFrequency("Hourly");
        homepage.clickContinue();
        element = driver.findElement(By.cssSelector("div.govuk-error-summary a"));
        Assert.assertTrue(homepage.elementErrorContains(element, "#amount"));
    }

    @AfterClass
    public static void mainTearDown() {
        driver.quit();
    }

}
