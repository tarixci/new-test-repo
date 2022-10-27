package SeleniumProjects;

import October8.Waits;
import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeleniumProject2 {

    public static String generateCardNumber(int selectedCard){

        Faker faker = new Faker();

        String Amex = "3" + (faker.number().digits(14));
        String Visa = "4" + (faker.number().digits(15));
        String MasterCard = "5" + (faker.number().digits(15));

        if(selectedCard == 0){
            return Visa;
        } else if (selectedCard == 1){

            return MasterCard;
        } else return Amex;
    }

    public static String generateExpirationDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/yy");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime sixMonthsLater = now.plusMonths((int)(Math.random()*72) ) ;
        return dtf.format(sixMonthsLater);
    }


    public static String getDate() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return myDateObj.format(myFormatObj);
    }

    public static void main(String[] args) {
        //1. Launch Chrome browser.

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nigar\\OneDrive\\Desktop\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //2. Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        //3. Login using username Tester and password test

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);


        //4. Click on Order link
        driver.findElement(By.linkText("Order")).click();

        //5. Enter a random product quantity between 1 and 100

        int randomQuantity = (int) (1 + (Math.random() * 100));

        WebElement quantityBox = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
        quantityBox.sendKeys(Keys.BACK_SPACE, "" + randomQuantity);

        //6. Click on Calculate and verify that the Total value is correct.

        int expectedTotalWithoutDiscount = randomQuantity * 100;
        int expectedTotalWithDiscount = (int) (expectedTotalWithoutDiscount - (expectedTotalWithoutDiscount * 0.08));
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        int actualTotal = Integer.parseInt(driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtTotal")).getAttribute("value"));

        if (randomQuantity < 10) {
            Assert.assertEquals(actualTotal, expectedTotalWithoutDiscount);
        } else {
            Assert.assertEquals(actualTotal, expectedTotalWithDiscount);
        }
        // 7. Generate and enter random first name and last name.

        Faker faker = new Faker();
        //System.out.println(faker.name().firstName() + " " + faker.name().lastName());

        String fullName = faker.name().fullName();

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(fullName);

        // 8.Generate and Enter random street address

        String street = faker.address().streetAddress();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys(street);

        // 9. Generate and Enter random city
        String city = faker.address().cityName();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys(city);

        //10. Generate and Enter random state
        String state = faker.address().state();

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys(state);

        // 11. Generate and Enter a random 5 digit zip code

        String zipcode = faker.number().digits(5);

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(zipcode);


        //-----------------------------------------------------------------------------------------------------------------------------------------

        // 12. Select the card type randomly. On each run your script should select a random type.


        int cardType = (int)(Math.random()*3); // 0-1-2
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_"+ cardType)).click();

        // 13. Generate and enter the random card number:

        String cardNumber = generateCardNumber(cardType);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(cardNumber);


       // 14. Enter a valid expiration date (newer than the current date)

        String expirationDate = generateExpirationDate();


        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys(expirationDate);

        // 15. Click on Process
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

       // 16. Verify that “New order has been successfully added” message appeared on the page.

        String expectedText = "New order has been successfully added.";
        String actualText = driver.findElement(By.className("buttons_process")).getText();

        Assert.assertTrue(actualText.contains(expectedText));


        // 17. Click on View All Orders link.

        driver.findElement(By.linkText("View all orders")).click();

        //18. The placed order details appears on the first row of the orders table. Verify that the entire information contained on the row (Name, Product, Quantity, etc) matches the previously entered information in previous steps.

       List<String> expectedValues = new ArrayList<>(Arrays.asList(fullName, "MyMoney", "" + randomQuantity,
                                                                   getDate(), street, city, state, zipcode,
                                                                   (cardType == 0 ? "Visa": cardType==1 ? "MasterCard":"American Express"),
                                                                   cardNumber, expirationDate));

        List<String> actualValues = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//tbody//tr//tr[2]//td"));

        for (WebElement column : elements) {
            actualValues.add(column.getText());
        }

        actualValues.remove(0);
        actualValues.remove(actualValues.size()-1);

        Assert.assertEquals(actualValues, expectedValues);

        // 19. Log out of the application.
        driver.findElement(By.id("ctl00_logout")).click();

        driver.quit();

        }}
