package repeat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Body02 {

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
        driver.get("http://mono-app-frontend.herokuapp.com/onboarding");
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(1000);


    }

    @After
    public void tearDown() {
//        driver.quit();

    }
}
