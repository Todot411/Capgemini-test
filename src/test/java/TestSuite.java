import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSuite {
    public static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        driver.get("https://www.tax.service.gov.uk/estimate-paye-take-home-pay/your-pay");
        try{
            String css = "h1";
            css+=".";
            if(driver.findElement(By.cssSelector(css)).isDisplayed()){
                System.out.println("Surprise!");
            }
        } finally {
            driver.quit();
        }
    }
}
