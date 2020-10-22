package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CalculatorHomePage extends BasicPage {


    public CalculatorHomePage(WebDriver driver) {
        super(driver);
    }

    private static String URL = "https://www.tax.service.gov.uk/estimate-paye-take-home-pay/your-pay";
    private static final By PAY_INPUT_BOX = By.cssSelector(".govuk-input");
    //private final List<WebElement> FREQUENCY_OF_PAY_RADIOS = this.driver.findElements(By.cssSelector(".govuk-radios__input"));
    private static final By CONTINUE_BUTTON = By.cssSelector("button");

    public void goHome(){
        driver.get(URL);
    }

    public void clickContinue() {
        waitAndClick(CONTINUE_BUTTON);
    }

    public void selectFrequency(String frequency){
        List<WebElement> FREQUENCY_OF_PAY_RADIOS = this.driver.findElements(By.cssSelector(".govuk-radios__input"));
        try {
            switch(frequency) {
                case "Hourly":
                    waitAndClick(FREQUENCY_OF_PAY_RADIOS.get(0));
                    break;
                case "Daily":
                    waitAndClick(FREQUENCY_OF_PAY_RADIOS.get(1));
                    break;
                case "Weekly":
                    waitAndClick(FREQUENCY_OF_PAY_RADIOS.get(2));
                    break;
                case "Monthly":
                    waitAndClick(FREQUENCY_OF_PAY_RADIOS.get(3));
                    break;
                case "Annually":
                    waitAndClick(FREQUENCY_OF_PAY_RADIOS.get(4));
                    break;
                default:
                    break;
            }
        } catch(ElementNotSelectableException e) {
            System.out.println("Invalid frequency");
        }
    }

    public void enterPayAmount(String amount) {
        typeInInput(PAY_INPUT_BOX, amount);
    }
}




