package October4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WarmUp {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nigar\\OneDrive\\Desktop\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.amazon.com/");
        Thread.sleep(500);

        // Navigate to amazon.com

        // Search for iphone
        String term  = "iphone";
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(term, Keys.ENTER);


        // Verify that seacrh result title contains the term


        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col s-widget-spacing-small sg-col-12-of-16']//span[@class='a-size-medium a-color-base a-text-normal']"));


        for (WebElement element : elements) {
            Assert.assertTrue(element.getText().toLowerCase().contains(term));
        }


        //Check apple checkbox

        //ElementClickInterceptedException: element click intercepted: Element <input type="checkbox" name="" value=""> is not clickable at point (217, 679). Other element would receive the click
        //This exception happens usually when one element is covered by another element, and the other element would get the click. Solution: if the element that is on top of the element lets you click, locate that
        // and click. IF you still need to click the element underneath, you will need to use JavascriptExecutor interface's click() method

        driver.findElement(By.xpath("//li[@id='p_89/Apple']//i")).click();
//

        // Check the 128 GB checkbox

        driver.findElement(By.xpath("//li[@id='p_n_feature_twelve_browse-bin/14674911011']//i")).click();



        // Verify that search results contain Apple and 128

        List<WebElement> results = driver.findElements(By.xpath("//div[@class='sg-col-4-of-12 s-result-item s-asin sg-col-4-of-16 sg-col s-widget-spacing-small sg-col-4-of-20']//span[@class='a-size-base-plus a-color-base a-text-normal']"));


        for (WebElement result : results) {
            System.out.println(result.getText());
            Assert.assertTrue(result.getText().toLowerCase().contains("apple"));
            Assert.assertTrue(result.getText().toLowerCase().contains("128"));
        }

        }
    }
