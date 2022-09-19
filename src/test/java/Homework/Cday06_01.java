package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Cday06_01 {
    /*
    Bir Class olusturalim YanlisEmailTesti
    1-http://automationpractice.com/index.php sayfasina gidelim
    2-Sign in butonuna basalim
    3-Email kutusuna @isareti olmayan bir mail yazip enter’a
    bastigimizda “Invalid email address” uyarisi ciktigini test edelim
      */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1-http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");


    }

    @AfterClass
    public static void tearDown() {
       driver.quit();


    }

    @Test

    public void test1() throws InterruptedException {
        // 2-Sign in butonuna basalim
        driver.findElement(By.className("login")).click();
        Thread.sleep(2000);


    }

    @Test

    public void test2() throws InterruptedException {
        //3-Email kutusuna @isareti olmayan bir mail yazip enter’a
        //    bastigimizda “Invalid email address” uyarisi ciktigini test edelim


        driver.findElement(By.xpath("//div/input[@id='email']")).sendKeys("alpCang1gmail.com", Keys.ENTER);
        //1.yol
        WebElement InvalidEmail = driver.findElement(By.xpath("//*[@id='center_column']"));
        Assert.assertTrue(InvalidEmail.getText().contains("Invalid email address"));

        //2.yol
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid email address.']")).isDisplayed());

        Thread.sleep(3000);



    }
}
