package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.security.Key;

public class C02_Actions extends TestBaseBeforeAfter {

    /*
1- https://www.facebook.com adresine gidelim
2- Yeni hesap olustur butonuna basalim
3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim

 */

    @Test
    public void test1() throws InterruptedException {

        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[title=\"Erforderliche und optionale Cookies erlauben\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]")).click();
        Thread.sleep(2000);
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
      WebElement isim= driver.findElement(By.xpath("(//input[@type=\"text\"])[2]"));
        isim.sendKeys("Erol");
        actions.sendKeys(Keys.TAB).
                sendKeys("Evren").
                sendKeys(Keys.TAB).
                sendKeys("evren@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("evren@gmail.com").
                sendKeys(Keys.TAB).sendKeys("123456").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("1").sendKeys(Keys.TAB).sendKeys("Tem").
                sendKeys(Keys.TAB).sendKeys("1982").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
    }



    }

