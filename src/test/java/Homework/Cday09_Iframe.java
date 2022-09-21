package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Cday09_Iframe {
    //Bir class olusturun: IframeTest02
    //http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //sayfadaki iframe sayısını bulunuz.
    //ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //ilk iframe'den çıkıp ana sayfaya dönünüz
    //ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
    //tıklayınız

    WebDriver driver;
    @Before

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test() throws InterruptedException {
        //http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        Thread.sleep(2000);
       driver.findElement(By.xpath("//*[text()='Alle akzeptieren']")).click();

       //sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeList=driver.findElements(By.xpath("//iframe"));
        System.out.println("Iframe sayisi= "+iframeList.size());
        //ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(iframeList.get(0));
      //driver.switchTo().frame(driver.findElement(By.cssSelector("[width=\"560\"]")));
        driver.findElement(By.cssSelector("[aria-label=\"Wiedergabe\"]")).click();
        //ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //tıklayınız
        driver.switchTo().frame(iframeList.get(1));
        driver.findElement(By.cssSelector("img[src=\"Jmeter720.png\"]")).click();



    }@After
    public void tearDown(){
     //driver.quit();




    }
}
