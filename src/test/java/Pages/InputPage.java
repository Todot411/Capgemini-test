package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InputPage extends BasicPage {

    public InputPage(WebDriver driver) {
        super(driver);
    }

    private static final By INPUT_FIELD = By.cssSelector("input");

    public void typeInInput(String inputKeys) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(INPUT_FIELD));
        element.sendKeys(inputKeys);
    }

}
