import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSuite {
    public static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        driver.get("https://github.com/");
        try{
            if(driver.findElement(By.className("hello")).isDisplayed()){
                System.out.println("Surprise!");
            }
        } finally {
            driver.quit();
        }
    }
}
