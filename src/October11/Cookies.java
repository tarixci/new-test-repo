package October11;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class Cookies {


    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nigar\\OneDrive\\Desktop\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.com/");

        Set<Cookie> cookies = driver.manage().getCookies();

        for (Cookie cookie : cookies) {
            System.out.println(cookie);

        }

driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Ray Ban", Keys.ENTER);

        driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//div[@class='sg-col-4-of-12 s-result-item s-asin sg-col-4-of-16 sg-col s-widget-spacing-small sg-col-4-of-20']//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")).click();

        driver.findElement(By.id("add-to-cart-button")).click();





    }
}
