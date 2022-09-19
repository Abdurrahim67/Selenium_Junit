package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Cday04_02 {
    public static void main(String[] args) throws InterruptedException {

        /*

2- https://www.amazon.com/ adresine gidin
3- Browseri tam sayfa yapin
4-Sayfayi “refresh” yapin
5-Sayfa basliginin “Spend less” ifadesi icerdigini test edin
6-Gift Cards sekmesine basin
7-Birthday butonuna basin
8-Best Seller bolumunden ilk urunu tiklayin
9- Gift card details’den 25 $’i secin
10-Urun ucretinin 25$ oldugunu test edin
11-Sayfayi kapatin
 */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5-Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        if (driver.getTitle().contains("Spend less")) {
            System.out.println("Tittle= PASSED ");
        } else System.out.println("Title= FAILED");

        Thread.sleep(2000);
        //6-Gift Cards sekmesine basin
        WebElement giftCards = driver.findElement(By.xpath("//*[@data-csa-c-slot-id='nav_cs_3']"));
        giftCards.click();
        Thread.sleep(1000);

        //7-Birthday butonuna basin
        driver.findElement(By.xpath("//*[text()='Geburtstag [US]']")).click();
        Thread.sleep(2000);

        //8-Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("//*[@aria-label='Bestseller']")).click();
        driver.findElement(By.cssSelector("img[alt='Amazon.com eGift Geschenkkarte']")).click();

        // 9- Gift card details’den 25 $’i secin
        driver.findElement(By.cssSelector("#a-autoid-28")).click();


        //10-Urun ucretinin 25$ oldugunu test edin
        String preis = driver.findElement(By.xpath("//*[@class='a-color-price a-text-bold']")).getText();

        if (preis.equals("$25,00")) {
            System.out.println("Preis= PASSED");
        }else System.out.println("Preis=FAILED");

        //11-Sayfayi kapatin
        driver.quit();

    }
}
