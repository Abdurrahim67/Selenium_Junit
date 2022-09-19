package AutomationExecercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC03_Login_User {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter incorrect email address and password
7. Click 'login' button
8. Verify error 'Your email or password is incorrect!' is visible
     */

    WebDriver driver;

    @Before

    public void setUp() {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test

    public void test() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homepage = driver.findElement(By.xpath("//*[@class='col-sm-6']"));
        Assert.assertTrue(homepage.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();

        //5. Verify 'Login to your account' is visible
        WebElement login = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(login.isDisplayed());

        //6. Enter incorrect email address and password
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("alpcan38@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("alpcan38@.1");

        //7. Click 'login' button
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement incorrectEmail = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
        Assert.assertTrue(incorrectEmail.isDisplayed());

        Thread.sleep(3000);

    }


    @After
    public void tearDown() {
         driver.quit();
    }

}
