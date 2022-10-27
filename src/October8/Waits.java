package October8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Waits {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nigar\\OneDrive\\Desktop\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait is set once per Driver initialization


        driver.get("https://www.lexus.com/");

        Thread.sleep(1000); // 10s wait -> static wait

        // Try limiting the use of Thread.sleep()

        //dynamic waits -> implicit, explicit, fluent

        driver.findElement(By.linkText("LEXUS INTERNATIONAL")).sendKeys(Keys.ENTER);

        //If the element is not found within the given time NoSuchElementException will be thrown

    }
}
