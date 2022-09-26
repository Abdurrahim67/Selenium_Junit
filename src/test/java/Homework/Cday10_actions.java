package Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class Cday10_actions extends TestBaseBeforeAfter {

    //       1 -)https://www.amazon.com/adresinegidelim
    //       2 -)Sag ust bolumde bulunan "Account & Lists" menusunun acilmasiicin
    //            mouse'u bu menunun ustunegetirelim
    //       3 -)"Music Library" butonunabasalim
    //       4 -) Acilan sayfada "DJ Mode Stations" yazisi oldugunu testedelim

    @Test
    public void test() throws InterruptedException {

        //   1 -)https://www.amazon.com/ adresinegidelim
        driver.get("https://www.amazon.com/");

        //   2 -)Sag ust bolumde bulunan "Account & Lists" menusunun acilmasi icin
        //        mouse'u bu menunun ustunegetirelim
     WebElement accountList= driver.findElement(By.cssSelector("[id=\"nav-link-accountList\"]"));
     Actions actions=new Actions(driver);
     actions.moveToElement(accountList).perform();
        //   3 -)"Music Library" butonunabasalim
        driver.findElement(By.xpath("//span[contains(text(),'Musikbibliothek')]")).click();
        Thread.sleep(2000);
        //   4 -) Acilan sayfada "DJ Mode Stations" yazisi oldugunu testedelim



    }

}
