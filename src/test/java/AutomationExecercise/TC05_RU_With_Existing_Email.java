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

public class TC05_RU_With_Existing_Email {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and already registered email address
    //7. Click 'Signup' button
    //8. Verify error 'Email Address already exist!' is visible



    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue( driver.findElement(By.xpath("//body")).isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();
        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());
        //6. Enter name and already registered email address
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Alp Can");
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("alpcan359@gmail.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();
        //8. Verify error 'Email Address already exist!' is visible
        WebElement already = driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
        Assert.assertTrue(already.isDisplayed());

    }

    @After
    public void tearDown() {
        driver.quit();

    }
}