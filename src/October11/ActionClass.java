package October11;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionClass {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nigar\\OneDrive\\Desktop\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.delta.com/");



        Actions actions = new Actions(driver);

        WebElement from = driver.findElement(By.xpath("fromAirportName"));
       actions.click(from).sendKeys("MIA").build().perform();
       actions.click().keyDown(Keys.SHIFT).sendKeys("mia").keyUp(Keys.SHIFT).build().perform(); //-> KEYS.SHIFT "mia"-ni upper case edir
       //actions.click(driver.findElement(By.xpath())).click();


    }
}
