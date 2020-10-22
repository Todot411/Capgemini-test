package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxPage extends BasicPage {
    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    public void selectYesOrNo(String answer) {
        List<WebElement> check = driver.findElements(By.cssSelector("input"));
        if(answer.equals("yes")){
            waitAndClick(check.get(0));
        } else if (answer.equals("no")) {
            waitAndClick(check.get(1));
        } else {
            System.out.println("Invalid answer");
        }
    }


}
