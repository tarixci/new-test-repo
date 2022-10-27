package October4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebTable2 {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nigar\\OneDrive\\Desktop\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.livecoinwatch.com/");

        //Find the column count
        //Find the header row and find the count of th's in there

        int columnCount = driver.findElements(By.xpath("//table[@class='lcw-table layout-fixed']//thead//th")).size();
        int rowCount = driver.findElements(By.xpath("//table[@class='lcw-table layout-fixed']//tbody//tr")).size();

        for (int i = 1;  i<=rowCount; i++) {
            for (int j = 1; j <= columnCount; j++) {

                String xpath = "//table[@class='lcw-table layout-fixed']//tbody//tr[" + 1 + "]//td[" + j + "]";

                //System.out.println(xpath);

                 System.out.println(driver.findElement(By.xpath(xpath)).getText());
            }

            System.out.println("-------------------------------------------");
        }
    }
}
