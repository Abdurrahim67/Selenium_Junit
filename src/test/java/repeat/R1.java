package repeat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class R1 {
    /*

●https://www.amazon.com/ adresinegidin.
-Test1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
oldugunu testedin
-Test2
1.Kategori menusunden Books seceneginisecin
2.Arama kutusuna Java yazin ve aratin
3.Bulunan sonuc sayisini yazdirin
4.Sonucun Java kelimesini icerdigini testedin
*/

    WebDriver driver;
    Select select;

    @Before

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");


    }

    @Test
    public void test1() {
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
        //oldugunu testedin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(ddm);

        List<WebElement> ddmList = select.getOptions();
        System.out.println(ddmList.size());
        int exoectedSayi = 45;
        int actualSayi = ddmList.size();
        Assert.assertNotEquals(exoectedSayi, actualSayi);
    }

    @Test
    public void test2() {
        //1.Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(ddm);
        // select.selectByVisibleText("Bücher");
        select.selectByIndex(3);
        //  select.selectByValue("search-alias=stripbooks-intl-ship");

        //2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        //3.Bulunan sonuc sayisini yazdirin

        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());
        //4.Sonucun Java kelimesini icerdigini testedin

        String expectedKelime="Java";
        String actualSonucYazisi=sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

    }

    @After
    public void tearDown() {
        //driver.quit();

    }
}
