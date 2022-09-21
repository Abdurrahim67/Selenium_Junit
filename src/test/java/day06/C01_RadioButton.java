package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_RadioButton {
/*

            https://www.facebook.com adresine gidin
            Cookies’i kabul edin
            “Create an Account” button’una basin
            “radio buttons” elementlerini locate edin
            Secili degilse cinsiyet butonundan size uygun olani secin

 */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test1() throws InterruptedException {

        //            https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //            Cookies’i kabul edin
        driver.findElement(By.xpath("//*[@data-cookiebanner='accept_button']")).click();
        //            “Create an Account” button’una basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
        //            “radio buttons” elementlerini locate edin
        WebElement weiblich = driver.findElement(By.xpath("(//*[@class='_8esa'])[1]"));
        WebElement mänlich = driver.findElement(By.xpath("(//*[@class='_8esa'])[2]"));
        WebElement divers = driver.findElement(By.xpath("(//*[@class='_8esa'])[3]"));

        //            Secili degilse cinsiyet butonundan size uygun olani secin
        if (!mänlich.isSelected()) {
            mänlich.click();

        }
        Thread.sleep(1000);
        weiblich.click();
        Thread.sleep(1000);
        divers.click();

    }

    @After
    public void tearDown() {
        driver.quit();

    }

}
