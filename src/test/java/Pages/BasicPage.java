package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicPage {

    private static final By CONTINUE_BUTTON =By.cssSelector("button");
    private static final By PAGE_TITLE = By.cssSelector("h1");

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasicPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    void waitAndClick(By selector){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
        element.click();
    }

    void waitAndClick(WebElement element){
        element.click();
    }

    public boolean elementIsVisible(WebElement element){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (ElementNotVisibleException e) {
            return false;
        }
    }

    public boolean elementErrorContains(WebElement element, String s){
        try {
            wait.until(ExpectedConditions.attributeContains(element, "href", s ));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public void clickContinue() {
        waitAndClick(CONTINUE_BUTTON);
    }

    public void pageIsDisplayed(String s) {
        WebElement pageTitle = driver.findElement(PAGE_TITLE);
        Assert.assertEquals(s, pageTitle.getText());
    }
}
