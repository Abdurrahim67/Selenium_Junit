package Homework;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Cday11_actions_dropDown2 {
    WebDriver driver;
    Actions actions;
    Select select;

    @Before

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions = new Actions(driver);


    }

    @Test
    public void test1() {
        //test01
        //-  amazon gidin
        driver.get("https://amazon.com");
        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın

        //1.yol
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(ddm);
        List<WebElement> ddmList = select.getOptions();
        ddmList.forEach(t -> System.out.println(t.getText()));

        //2.yol
        /* List<WebElement> drops = driver.findElements(By.xpath("//option"));
        System.out.println(drops.size());
        for (WebElement w : drops) {
            System.out.println(w.getText());
        }

       */


        //dropdown menude 40 eleman olduğunu doğrulayın
        int actualSayi = ddmList.size();
        System.out.println(actualSayi);
        int expectedSayi = 40;
        Assert.assertNotEquals(expectedSayi, actualSayi);


        //Test02
//dropdown menuden Elektronik bölümü seçin
        select.selectByIndex(6);
        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone", Keys.ENTER);

        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String actualSonuc = driver.findElement(By.xpath("//span[contains(text(),'iphone')]")).getText();
        String expectedSonuc = "iphone";
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));

        // String actualSonuc= driver.findElement(By.className("a-color-state a-text-bold")).getText();

        //ikinci ürüne relative locater kullanarak tıklayin


        //ürünün title'ni ve fiyatını variable'a  assign edip ürünü sepete ekleyelim

        //Test03
        //yeni bir sekme açarak amazon anasayfaya gidin
        //dropdown'dan bebek bölümüne secin
        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        //sonuç yazsının puset içerdiğini test edin
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin


        //Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

    }

    @After
    public void tearDown() {


    }
}
