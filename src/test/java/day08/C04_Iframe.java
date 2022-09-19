package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Iframe {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test

    public void test() throws InterruptedException {
        //https://html/tags/iframe/ adresnine gidiniz

        driver.get("https://html.com/tags/iframe/");
        WebElement youtubeFrame = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(youtubeFrame);
        // youtubeFrame.click();--> böyle de calisabiliyor
        driver.findElement(By.xpath("//*[@aria-label='Wiedergabe']")).click();

        Thread.sleep(3000);
    }

    @After
    public void tearDown() {
        // driver.quit();
    }
}