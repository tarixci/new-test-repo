import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumProject {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nigar\\OneDrive\\Desktop\\BrowserDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));

        driver.get("http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");

        String expectedTitle = "Welcome to Duotify!";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.findElement(By.id("hideLogin")).click();

        driver.findElement(By.name("username")).sendKeys("gononido");
        driver.findElement(By.name("firstName")).sendKeys("Jon");
        driver.findElement(By.name("lastName")).sendKeys("do");
        driver.findElement(By.name("email")).sendKeys("gononido2022@yahoo.com");
        driver.findElement(By.name("email2")).sendKeys("gononido2022@yahoo.com");
        driver.findElement(By.name("password")).sendKeys("condo6789");
        driver.findElement(By.name("password2")).sendKeys("condo6789", Keys.ENTER);

       // Thread.sleep(500);

        if(driver.getPageSource().contains("You Might Also Like")){

            System.out.println("Pass");
        }else{
            System.out.println("FAIL");
        }

        String expectedURL = "http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?";
        String actualURL = driver.getCurrentUrl();


        if(actualURL.equals(expectedURL)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL. The expected URL is: " + expectedURL);
            System.out.println("The actual URL is: " + actualURL);
        }
          // Thread.sleep(500);

        if(driver.getPageSource().contains("Jon Do")){

            System.out.println("Pass");
        }else{
            System.out.println("FAIL");
        }

         driver.findElement(By.id("nameFirstAndLast")).click();
         if(driver.getPageSource().contains("Jon Do")) {
             System.out.println("PASS");
         }else{
             System.out.println("FAIL");
         }

              driver.findElement(By.id("rafael")).click();
        Thread.sleep(500);
        String expectedURLAfter = "http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php";
        String actualURLAfter = driver.getCurrentUrl();

        if(actualURLAfter.equals(expectedURLAfter)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL. The expected URL is: " + expectedURLAfter);
            System.out.println("The actual URL is: " + actualURLAfter);
        }

        Thread.sleep(500);
        driver.findElement(By.name("loginUsername")).sendKeys("gononido");
        driver.findElement(By.name("loginPassword")).sendKeys("condo6789", Keys.ENTER);

        Thread.sleep(500);
        if(driver.getPageSource().contains("You Might Also Like")){

            System.out.println("Pass");
        }else{
            System.out.println("FAIL");
        }
    }}


