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

public class TC08_Verify_TC_Page {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. The products list is visible
    //7. Click on 'View Product' of first product
    //8. User is landed to product detail page
    //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand

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
        //4. Click on 'Products' button
        driver.findElement(By.cssSelector("a[href='/products']")).click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='All Products']")).isDisplayed());

        //6. The products list is visible
        Assert.assertTrue(driver.findElement(By.className("features_items")).isDisplayed());
        Thread.sleep(5000);
        //7. Click on 'View Product' of first product
        driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).click();
        Thread.sleep(1000);

        //8. User is landed to product detail page
        Assert.assertTrue(driver.findElement(By.className("product-information")).isDisplayed());

        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        WebElement productName = driver.findElement(By.xpath("//h2[normalize-space()='Blue Top']"));
        Assert.assertTrue(productName.isDisplayed());
        WebElement category = driver.findElement(By.xpath("//p[normalize-space()='Category: Women > Tops']"));
        Assert.assertTrue(category.isDisplayed());
        WebElement price = driver.findElement(By.xpath("//span[normalize-space()='Rs. 500']"));
        Assert.assertTrue(price.isDisplayed());
        WebElement availability = driver.findElement(By.xpath("//b[normalize-space()='Availability:']"));
        Assert.assertTrue(availability.isDisplayed());
        WebElement condition = driver.findElement(By.xpath("//b[normalize-space()='Condition:']"));
        Assert.assertTrue(condition.isDisplayed());
        WebElement brand = driver.findElement(By.xpath("//b[normalize-space()='Brand:']"));


    }

    @After
    public void tearDown () {
          driver.quit();

    }


}
