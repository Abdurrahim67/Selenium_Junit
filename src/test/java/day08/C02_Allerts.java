package day08;

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

public class C02_Allerts {
        /*
    Bir web sitesine girdiğimizde karşımıza bir uyarı mesayı yada bir buttona tıkladığımızda bir uyarı(alert)
    çıkabilir. Eğer bu uyarıya incele(mause sağ tik-inspect) yapabiliyorsak bu tür alert'lere HTML alert denir
    ve istediğimiz locate'i alabiliriz. Ama gelen uyarı kutusuna müdehale(Sağ tik-incele) edemiyorsak bu tür
    alert'lere js alert denir. js alert'lere müdehale edebilmek için
    - tamam yada ok için driver.switchTo().alert().accept() kullanılır
    - iptal için driver.switchTo().alert().dismiss() methodu kullanılır
    - Alert içindeki mesajı almak için driver.switchTo().alert().getText() kullanılır
    - Alert bizden bir metin istiyorsa driver.switchTo().alert().sendKeys("") kullanılır
     */


    /*

Bir class olusturun: Alerts
https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
Bir metod olusturun: acceptAlert
1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
Bir metod olusturun: dismissAlert
2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
“successfuly” icermedigini test edin. Alert üzerindeki mesajı yazdırınız
Bir metod olusturun: sendKeysAlert
3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
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
    public void test1() {
        //https://the-internet.herokuapp.com/javascript_alerts
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        WebElement mesaj = driver.findElement(By.xpath("//*[@id='result']"));
        String actualMesaj = mesaj.getText();
        String expectedMesaj = "You successfully clicked an alert";
        Assert.assertEquals(expectedMesaj, actualMesaj);


    }

    @Test
    public void test2() throws InterruptedException {
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin. Alert üzerindeki mesajı yazdırınız
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        // Alert üzerindeki mesajı yazdırınız
        System.out.println("2.Buttonun Alert Mesaji" + driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
        WebElement mesaj = driver.findElement(By.xpath("//*[@id='result']"));
        String actualMesaj = mesaj.getText();
        String expectedMesaj = "successfuly";
        Assert.assertFalse(actualMesaj.contains(expectedMesaj));


    }

    @Test
    public void test3() {
        //3.butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK(tamam) butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("abdurrahim");
        driver.switchTo().alert().accept();
        WebElement mesaj = driver.findElement(By.xpath("//*[@id='result']"));
        String expectedMesaj="abdurrahim";
        String actualMesaj=mesaj.getText();
        Assert.assertTrue(actualMesaj.contains(expectedMesaj));


    }

    @After
    public void tearDown() {
        driver.quit();

    }
}
