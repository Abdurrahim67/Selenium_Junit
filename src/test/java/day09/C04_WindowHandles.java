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
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandles {

    /*
1-Tests package'inda yeni bir class olusturun: WindowHandle2
2-https://the-internet.herokuapp.com/windows adresine gidin.
3-Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
4-Sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
5-Click Here butonuna basın.
6-Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.
7-Sayfadaki textin "New Window" olduğunu doğrulayın.
8-Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu  doğrulayın.
 */
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test1() {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Opening a new window']")).isDisplayed());
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

         /*
        NOT: String'lerden oluşan bir list oluşturup getWindowHandles() method'u ile
        açık bulunan tüm sayfaların / pencerelerin WindowHandle değerlerini o list'e atıyoruz.
        Daha sonra driver.switchTo().window() method'unun içine oluşturduğumuz list'ten
        hangi web sayfasını istiyorsak onun indeksini yazarak sayfalar arasında geçiş yapabiliyoruz.
        Yapı şu şekilde: driver.switchTo().window(listAdı.get(window'un indeks numarası))
        Örneğimizde windowList adındaki list'imizden 1. elementi getirdik.
        0 ilk sayfanın WindowHandle değerini, 1 ise ikinci sayfanın WindowHandle değerini verir.
        */

        /*
        Set<String> windowHandleseti= driver.getWindowHandles();
        System.out.println(windowHandleseti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
         */




        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String expectedTitle="New Window";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);


        //Sayfadaki textin “New Window” olduğunu doğrulayın.
       Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowList.get(0));
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
    }


}
