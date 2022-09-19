package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {

    ////1- Amazon Sayfasina girelim
    ////2- Url'nin amazon içerdiğini test edelim
    ////3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
    ////4- title'in Best Buy içerdiğini test edelim
    ////5- İlk sayfaya dönüp sayfada java aratalım
    ////6- Arama sonuclarının java içerdiğini test edelim
    ////7- Yeniden bestbuy sayfasına gidelim
    ////8- Logonun görünürlüğünü test edelim
    ////9- Sayfaları Kapatalım


    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test
    public void test() {
        //1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();
        //2- Url'nin amazon içerdiğini test edelim
        String expectedUrl = driver.getCurrentUrl();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle= driver.getWindowHandle();
        //4- title'in Best Buy içerdiğini test edelim
        String expectedTitle="Best Buy";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);
        //6- Arama sonuclarının java içerdiğini test edelim
        String aramaSonucu=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        String arananKelime="java";
        Assert.assertTrue(aramaSonucu.contains(arananKelime));
        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWindowHandle);
        //8- Logonun görünürlüğünü test edelim
        WebElement logo=driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());



    }

    @After
    public void tearDown() {

         driver.quit();

    }
}

