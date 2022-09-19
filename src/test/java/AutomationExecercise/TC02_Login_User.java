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

public class TC02_Login_User {
    WebDriver driver;

    @Before
    public void setup() {
        // 1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void method1() throws InterruptedException {
        //2.Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3.Verify that home page is visible successfully
        //1. yol
        // System.out.println("home page= " + driver.findElement(By.xpath("//*[@lang='en']")).isDisplayed());

        //2.yol
        WebElement homePage = driver.findElement(By.xpath("//*[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.linkText("Signup / Login")).click();
        //5. Verify 'Login to your account' is visible

        //1.yol
        //System.out.println("Login to your account= " + driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());
        //2.yol
        WebElement login = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(login.isDisplayed());

        //6. Enter correct email address and password
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("alpcan389@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("alpcan389@.1");

        //7. Click 'login' button
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
        //8. Verify that 'Logged in as username' is visible
        //1.yol
      //  System.out.println("Logged in as username= " + driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());
        //2.yol
        WebElement logged = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(logged.isDisplayed());


        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //10. Verify that 'ACCOUNT DELETED!' is visible

        //1.yol

      /*  String sonuc = driver.findElement(By.xpath("(//*[@class='container'])[2]")).getText();
        if (sonuc.contains("ACCOUNT DELETED!")) {
            System.out.println("ACCOUNT DELETED!= PASSED");
        } else System.out.println("ACCOUNT DELETED!= FAILED");
         */
        //2.yol
        String accountDeleted = driver.findElement(By.xpath("(//*[@class='container'])[2]")).getText();
        Assert.assertTrue(accountDeleted.contains("ACCOUNT DELETED!")); //-->FAILED



        Thread.sleep(3000);
    }


    @After

    public void tearDown() {

       driver.quit();
    }
}
