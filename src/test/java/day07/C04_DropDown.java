package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_DropDown {

    //Bir class oluşturun: DropDown
    //https://the-internet.herokuapp.com/dropdown adresine gidin.
    //Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //Tüm dropdown değerleri(value) yazdırın
    //Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True , degilse
    //False yazdırın.

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test1() {

        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddmList = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(ddmList);
        //1.yol
        select.selectByIndex(1);
        //2.yol
        ddmList.sendKeys("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("===========================");
        //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("=========================");
        //Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("=========================");
        //Tüm dropdown değerleri(value) yazdırın
        List<WebElement> tumDddm=select.getOptions();
        //Lambda ile
        tumDddm.forEach(t->System.out.println(t.getText()));
        //foreach ile
        for (WebElement w:tumDddm
             ) {
            System.out.println(w.getText());
        }
        System.out.println("=========================");

        //Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True , degilse
        //False yazdırın.
        System.out.println(tumDddm.size());
        //1.yol
        if(tumDddm.size()==4){
            System.out.println("True");
        }else System.out.println("False");

        //2.yol
        int expectedSize=4;
        int actualSize=tumDddm.size();
        Assert.assertNotEquals(expectedSize,actualSize);


    }
}