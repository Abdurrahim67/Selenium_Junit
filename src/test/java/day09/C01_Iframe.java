package day09;

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

public class C01_Iframe {
     /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
         dogrulayin ve konsolda yazdirin
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
    public void test () throws InterruptedException {

        // ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iframeYazisi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());
        System.out.println(iframeYazisi.getText());
        // ○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement textBox=driver.findElement(By.id("mce_0_ifr"));//Frame'e gecis yapmadan önce orayi id ile locat ettik.
        driver.switchTo().frame(textBox);// locate ettigimiz frame gecmek icin bu methodu kullaniriz
        WebElement textBoxFreme=driver.findElement(By.xpath("//p"));
        textBoxFreme.clear();// Claear methodu text box'in icini temizler
        textBoxFreme.sendKeys("Merhaba Dunya!");



        // ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        // dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent();
        //driver.switchTo().parentFrame(); ->> ile de oluyor
        WebElement text= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(text.isDisplayed());
        System.out.println(text.getText());


    }

    @After
    public void tearDown () {
        //  driver.quit();

    }
}
