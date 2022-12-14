package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C03_SenkranizasyonWait extends TestBaseBeforeAfter {
    // 1. Bir class olusturun : WaitTest
    // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //    Iki metod icin de asagidaki adimlari test edin.
    // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 4. Remove butonuna basin.
    // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
    // 6. Add buttonuna basin
    // 7. It's back mesajinin gorundugunu test edin


    @Test
    public void imlicitlyWaitTest1() {

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();
        // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's gone!\"]")).isDisplayed());
        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();
        // 7. It's back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's back!\"]")).isDisplayed());


    }


    @Test
    public void explicitWaitTest2() {
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();
        // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement itsGoneWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGoneWE.isDisplayed());
        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();
        // 7. It's back mesajinin gorundugunu test edin
        WebElement itsBackWE=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackWE.isDisplayed());


    }

}               /*
                imlicitlyWait kulland??????m??z bu method'da sayfadaki b??t??n webelementler i??in
                max belirtti??imiz s??re alt??nda b??t??n web elementler i??in bekler
                  */

        /*
        explicitWait itsgoneWE g??r??n??r olmas??n?? beklerken o web elementinin locatini kullanarak assert yapmak
        sorun olur ve exeption f??rlat??r. Hen??z g??r??lmeyen bir Webelementin locate edilmeside otamasyon i??in
        m??mk??n olmaz. Bu durumda bekleme i??lemi i??in explicitWait'i locate ile birlikte kullan??r??z
         */

//implicitly wait testten once calsitirilir ve calistirilan testin tamamina etki eder
//explicitly wait ise once obje olarak olusturulur sonra
// sadece kullanildigi yerde ve belirlenen sarta gore calisir. class yada test in tamamina uygulanmaz
