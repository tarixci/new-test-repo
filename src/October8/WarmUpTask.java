package October8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WarmUpTask {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nigar\\OneDrive\\Desktop\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //to to https://www.webstaurantstore.com/ page
        driver.get("https://www.webstaurantstore.com/");

        //search for "stainless work table"
        driver.findElement(By.id("searchval")).sendKeys("stainless work table", Keys.ENTER);

        //Check the all search results from the current page ensuring every product has the word 'Table' in its title

        List<WebElement> elements = driver.findElements(By.xpath(""));

        for (WebElement element : elements) {

            Assert.assertTrue(element.getText().toLowerCase().contains("table"), "The text is: " + element.getText());

        }
        // add the first found item to the cart

        driver.findElement(By.xpath(""));

        driver.findElement(By.id("buyButton")).click();

       // Assert.assertTrue(element);


        //Empty Cart

    }




}
