package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Cday07_01_DropDown {
        /*
 1. http://zero.webappsecurity.com/ Adresine gidin
2. Sign in butonuna basin
3. Login kutusuna “username” yazin
4. Password kutusuna “password.” yazin
5. Sign in tusuna basin
6. Online Banking sayfasina gidin
6. Pay Bills sayfasina gidin
7. “Purchase Foreign Currency” tusuna basin
8. “Currency” drop down menusunden "Eurozone (euro)"u secin
9. “amount” kutusuna bir sayi girin
10. “US Dollars” in secilmedigini test edin
11. “Selected currency” butonunu secin
12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://zero.webappsecurity.com/");

    }

    @Test
    public void test() throws InterruptedException {
        //2. Sign in butonuna basin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        //3. Login kutusuna “username” yazin
        driver.findElement(By.cssSelector("input[id='user_login']")).sendKeys("username");
        //4. Password kutusuna “password.” yazin
        driver.findElement(By.cssSelector("input[id='user_password']")).sendKeys("password");
        Thread.sleep(2000);
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        Thread.sleep(2000);
         
        Thread.sleep(2000);
        //6. Online Banking sayfasina gidin
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
        Thread.sleep(1000);
        //7. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        Thread.sleep(1000);
        //8. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
        //9. “Currency” drop down menusunden "Eurozone (euro)"u secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");
        //10. “amount” kutusuna bir sayi girin
        driver.findElement(By.cssSelector("input[id='pc_amount']")).sendKeys("1500");
        //11. “US Dollars” in secilmedigini test edin
        WebElement usDollars = driver.findElement(By.xpath("(//*[@name='inDollars'])[1]"));
        Assert.assertFalse(usDollars.isSelected());
        //12. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
        //13. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();
        //14. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        String expectedSonuc = "Foreign currency cash was successfully purchased.";
        String actualSonuc = driver.findElement(By.xpath("//*[@id='alert_content']")).getText();
        Assert.assertEquals(actualSonuc, expectedSonuc);

        Thread.sleep(5000);

    }

    @After
    public void tearDown() {
        driver.quit();

    }
}
