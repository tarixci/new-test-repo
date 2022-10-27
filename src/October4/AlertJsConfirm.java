package October4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AlertJsConfirm {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nigar\\OneDrive\\Desktop\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.duotech.io/");

        driver.findElement(By.xpath("-------------")).click();

        driver.switchTo().alert().sendKeys("Hello JS alert");
        driver.findElement(By.linkText("Elemental Selenium")).click();



        String textOfTheAlerBox = driver.switchTo().alert().getText();
        System.out.println(" The alert box text is: " + textOfTheAlerBox);

        driver.switchTo().alert().accept(); // Click ON
        driver.switchTo().alert().dismiss(); // click CANCEL

        // Non-Jacascript alerts which are called popups or modal alerts/windows can be handled like a normal element
        // by inspecting them and clicking on a button or x to remove it


    }}
