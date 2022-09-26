package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_FileExistUpload extends TestBaseBeforeAfter {

    @Test
    public void test1() {


        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        WebElement dosyaSec = driver.findElement(By.cssSelector("#file-upload"));
        //Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = "C:\\Users\\HP-ZBook 3\\Desktop\\text.rtf";
        dosyaSec.sendKeys(dosyaYolu);
        //Upload butonuna basalim.
        driver.findElement(By.cssSelector("#file-submit")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        driver.findElement(By.xpath("//*[text()='File Uploaded!']"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());


    }
}
