package AutomationExecercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC06_Contact_Us {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Contact Us' button
    //5. Verify 'GET IN TOUCH' is visible
    //6. Enter name, email, subject and message
    //7. Upload file
    //8. Click 'Submit' button
    //9. Click OK button
    //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    //11. Click 'Home' button and verify that landed to home page successfully

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }

    @Test
    public void test () throws InterruptedException {

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//body")).isDisplayed());
        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[text()=' Contact us']")).click();
        //5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Get In Touch']")).isDisplayed());
        //6. Enter name, email, subject and message
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Alp Can");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("alpcan359@gmail.com");
        driver.findElement(By.cssSelector("input[name='subject']")).sendKeys("test automation");
        driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("test automation is successfully");


        //7. Upload file
        driver.findElement(By.cssSelector("input[type='file']")).sendKeys("C:\\Users\\HP-ZBook 3\\Desktop\\Neues Textdokument.txt");
        Thread.sleep(3000);
        //8. Click 'Submit' button
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        Thread.sleep(3000);
        //9. Click OK button
        driver.switchTo().alert().accept();
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertTrue(driver.findElement(By.cssSelector(".status alert alert-success")).isDisplayed());
        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//*[@class='fa fa-angle-double-left']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//body")).isDisplayed());




    }

    @After
    public void tearDown () {
        driver.quit();

    }


}
