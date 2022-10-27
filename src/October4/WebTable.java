package October4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebTable {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nigar\\OneDrive\\Desktop\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_Username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);
        driver.findElement(By.linkText("View all products")).click();

        //Verify that 2nd row and 1st columns text is MyMoney

        String actualText = driver.findElement(By.xpath("")).getText();
        String  expectedText = "MyMoney";

        System.out.println(actualText);
        Assert.assertEquals(actualText, expectedText);

       // List<String> expectedHeaderRowValues = new Arrays.asList("Product name", "Price", "Discount");





    }

}
