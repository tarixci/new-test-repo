package October4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alerts {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nigar\\OneDrive\\Desktop\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.duotech.io/");

        // When alert is active and you don't handle it and try interacting with the page UnhandledAlertException is thrown

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        alert.accept(); // ikisinden birini sece bilersen: dismiss() or accept();




    }

}
