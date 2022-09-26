package Homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class D19_WebTbales extends TestBaseBeforeAfter {

    //ÖDEV 3

    //Bir Class olusturun D19_WebtablesHomework
    //“https://demoqa.com/webtables” sayfasina gidin
    //Headers da bulunan department isimlerini yazdirin
    //sutunun basligini yazdirin
    //Tablodaki tum datalari yazdirin
    //Tabloda kac cell (data) oldugunu yazdirin
    //Tablodaki satir sayisini yazdirin
    //Tablodaki sutun sayisini yazdirin
    //Tablodaki 3.kolonu yazdirin
    //Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
    //Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin

    @Test
    public void test() {

        //“https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //Headers da bulunan department isimlerini yazdirin
        List<WebElement> departmentList = new ArrayList<>(driver.findElements(By.xpath("//div[@role='gridcell'][6]")));
        departmentList.forEach(t -> System.out.println("Department : " + t.getText()));

        //sutunun basligini yazdirin
        System.out.println("-----------------------Tablo Title-----------------------");
        WebElement baslik = driver.findElement(By.xpath("//div[@class='rt-thead -header']"));
        System.out.println("Tablo Title : " + baslik.getText());
        System.out.println("-----------------------Tablo Title-----------------------");

        //Tablodaki tum datalari yazdirin
        System.out.println("-------------------------TUM TABLO--------------------------");
        WebElement tumTablo = driver.findElement(By.xpath("//div[@class='rt-table']"));
        System.out.println(tumTablo.getText());
        System.out.println("-------------------------TUM TABLO--------------------------");

        //Tabloda kac cell (data) oldugunu yazdirin
        List<WebElement> cellList = driver.findElements(By.xpath("//div[@class='rt-td']"));
        System.out.println("data sayisi=" + cellList.size());
        System.out.println("------------------------------------------------------------");
        //Tablodaki satir sayisini yazdirin
        List<WebElement> rowList = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("satir sayisi=" + rowList.size());
        System.out.println("------------------------------------------------------------");

        //Tablodaki sutun sayisini yazdirin
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println("sutunSayisi= " + sutunSayisi.size());
        System.out.println("------------------------------------------------------------");

        //Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuColumn = driver.findElements(By.xpath("//div[@class='rt-td' and @role='gridcell'][3]"));
        ucuncuColumn.forEach(t -> System.out.println("3.column= " + t.getText()));

        //Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin

        WebElement kierraSalary = driver.findElement(By.cssSelector(".rt-tbody>:nth-child(3)>.rt-tr.-odd>:nth-last-of-type(3)"));
        System.out.println("Kierra Salary -> " + kierraSalary.getText());
    }

    //Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin

    public void table(int row, int column) { // method

        WebElement cell = driver.findElement(By.cssSelector(".rt-tbody>:nth-child(" + row + ")>:nth-child(1)>:nth-child(" + column + ")"));

        System.out.println(row + ". satir " + column + " . sutundaki data -> " + cell.getText());
    }
}
