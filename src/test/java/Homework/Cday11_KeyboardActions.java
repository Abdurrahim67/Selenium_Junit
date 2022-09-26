package Homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Cday11_KeyboardActions extends TestBaseBeforeAfter {
    //Bir Class olusturalim KeyboardActions2
    //https://html.com/tags/iframe/ sayfasina gidelim
    // 3- video'yu gorecek kadar asagi inin
    //videoyu izlemek icin Play tusuna basin
    //videoyu calistirdiginizi test edin


    @Test
    public void test() throws AWTException {

        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        // 3- video'yu gorecek kadar asagi inin

        //1.yol
        //WebElement scroll= driver.findElement(By.xpath("//*[@class='site-header clearfix']"));
        //actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //2.yol
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,1000)");

        //videoyu izlemek icin Play tusuna basin
        List<WebElement> iframeList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0));

        driver.findElement(By.xpath("//*[@aria-label=\"Wiedergabe\"]")).click();

        //videoyu calistirdiginizi test edin



    }


}
