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
import java.util.ArrayList;
import java.util.List;

public class TC09_Search_Product {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. Enter product name in search input and click search button
    //7. Verify 'SEARCHED PRODUCTS' is visible
    //8. Verify all the products related to search are visible

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
        Assert.assertTrue(driver.findElement(By.cssSelector("[class=\"logo pull-left\"]")).isDisplayed());
        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        Thread.sleep(2000);
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed());
        Thread.sleep(2000);
        //6. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("T-Shirt");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[id=\"submit_search\"]")).click();
        //7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(driver.findElement(By.className("features_items")).isDisplayed());
        //8. Verify all the products related to search are visible

        List<WebElement> productsList = new ArrayList<>(driver.findElements(By.xpath("//*[@class='productinfo text-center']/p")));
        //1.yol -->foreach ile
        for (WebElement w : productsList
        ) {
            Assert.assertTrue(w.isDisplayed());

        }
        //2.yol-->lambda ile
        productsList.stream().forEach(t -> t.isDisplayed());



    }

    @After
    public void tearDown() {


    }

}
