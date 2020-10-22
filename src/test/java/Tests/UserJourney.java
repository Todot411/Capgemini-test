package Tests;

import Pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserJourney {
    public WebDriver driver = new ChromeDriver();
    private CalculatorHomePage home = new CalculatorHomePage(driver);
    private InputPage inputPage = new InputPage(driver);
    private CheckboxPage checkboxPage = new CheckboxPage(driver);
    private CheckAnswersPage answerPage = new CheckAnswersPage(driver);
    private ResultsPage results = new ResultsPage(driver);

    @Before
    public void individualSetUp() {
        home.goHome();
    }

    /**
     * Fill in pay (10)
     * Select frequency (hourly)
     * Hours a week (25)
     * Select yes for pension age
     * Leave tax code blank
     * Select no for Scottish
     * Click to get results
     * Verify the results page is displayed
     */
    @Test
    public void hourlyPayInputs() {
        inputPage.typeInInput("10");
        home.selectFrequency("Hourly");
        home.clickContinue();
        inputPage.typeInInput("25");
        inputPage.clickContinue();
        checkboxPage.selectYesOrNo("yes");
        checkboxPage.clickContinue();
        inputPage.clickContinue();
        checkboxPage.selectYesOrNo("no");
        checkboxPage.clickContinue();
        answerPage.clickContinue();
        inputPage.pageIsDisplayed("Your estimated take-home pay");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
