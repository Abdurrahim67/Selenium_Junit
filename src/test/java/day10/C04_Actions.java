package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {


        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // Cizili alan uzerinde sag click yapalim
        WebElement testBox = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(testBox).contextClick().perform();
        //Alert'te cikan yazinin "You selected a context menu" oldugunu test edelim.
        String expectedAlertYazisi = "You selected a context menu";
        String actualActualYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi, actualActualYazisi);
        //Tamam diyerek alert'i kapatalim
        driver.switchTo().alert().accept();
        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        //Acilan sayfada h1 taginda "Elemental Selenium" yazdigini test edelim
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        String expectedH1TagYazisi = "Elemental Selenium";
        String actualH1TagYazisi = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actualH1TagYazisi, expectedH1TagYazisi);


    }
}
