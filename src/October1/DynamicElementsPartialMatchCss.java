package October1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicElementsPartialMatchCss {


    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nigar\\OneDrive\\Desktop\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.google.com/");

        System.out.println(driver.findElement(By.cssSelector("input[value^= 'AJiK0']")).getTagName());
        // starts-with Xpath -> //input[starts-with(@value, 'AJiK0')]
        // starts-with CSS -> input[value^= 'AJiK0']


        System.out.println(driver.findElement(By.cssSelector("div[aria-controls$='_1']")).getTagName());
        // ends with  Xpath -> //div[ends-with(@aria-controls, '_1')]
        // ends with  Css ->  div[aria-controls$='_1']


        System.out.println(driver.findElement(By.cssSelector("div[aria-controls*='A']")).getTagName());

        // contains Xpath -> //div[contains(@aria-controls, '_1')]
        // contains CSS -> div[aria-controls*='A']



        // Differences between XPath and CSS

        // - Css has simpler syntax
        // - Css is native to browsers, it is faster than Xpath, the locators are guaranteed to work across all browsers
        //    whereas Xpath engine is different for different browsers, the methods might not work properly all the time (e.g ends-with())

        // - Xpath can locate an element by its text, CSS Selector cannot do that
        // - Xpath can locate element both forwards and backwards, whereas CSS can only locate them in forwards

        // Eger element tamamile Dynamic olsa onda cozum olaraq following veya preciding elemente veya parent elemente baxib ona gore xpath yazmaliyiq
        // yox eger bunlari da ede bilmirikse onda Full Xpath linki copy-paste edib kullana bilerik. -> /html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input (Bu full Xpath-dir)
        // Amma bu, en son cozum olmalidir, cunki Full Xpath cox guvenli bir yontem deyil.


    }
}
