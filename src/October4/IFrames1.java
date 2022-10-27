package October4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IFrames1 {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nigar\\OneDrive\\Desktop\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.duotech.io/enroll-sqae2");


        // driver.switchTo().frame(0); //Select a frame by its (zero-based) index.
        //driver.switchTo().frame("iframe"); // locate it by id or name attribute

        WebElement iframeForForm = driver.findElement(By.xpath("//iframe[starts-with(@id,'16649')]"));
        driver.switchTo().frame(iframeForForm);


        driver.findElement(By.xpath("//input[@placeholder='First']")).sendKeys("Johnny");

        driver.switchTo().defaultContent();// switches the context to the main window
        //driver.switchTo().parentFrame(); -> switches to direct parent iframe


        driver.findElement(By.linkText("LMS")).click();

    }

}
