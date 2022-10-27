package October4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebTable3 {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nigar\\OneDrive\\Desktop\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.livecoinwatch.com/");

    // Find the largest value in 1hour change column from the dynamic table where crypto prices are changing

        List<WebElement> elements = driver.findElements(By.xpath("//table[@class='lcw-table layout-fixed']//tbody//tr//td[8]"));

        double max = Double.parseDouble(elements.get(0).getText().replace("%", "").replace("-", ""));
        int indexOfMax = 0;
        for (int i = 1; i < elements.size(); i++){

    // elements = driver.findElements(By.xpath("//table[@class='lcw-table layout-fixed']//tbody//tr//td[8]")); -> to get the fresh reference
    // StaleElementReferenceException happens usually when you store lots of elements in a list and later in your code try to use them which
    // by that time could become stale(old). To fix it, you usually need to get the fresh list again.

            double next = Double.parseDouble(elements.get(i).getText().replace("%", "").replace("-", ""));
            if (next > max){
                max = next;
                indexOfMax = i;
            }
        }
        System.out.println("The max change in the last hour is: " + max);

        String xpathDynamic = "//table[@class='lcw-table layout-fixed']//tr["+ (indexOfMax + 1)+"]//div[@class='filter-item-name mb0 text-left']";
        System.out.println("The name of the cyrpto that has the biggest change is: " + driver.findElement(By.xpath(xpathDynamic)).getText());


    }
}
