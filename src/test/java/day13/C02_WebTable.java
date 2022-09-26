package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

/*
Genel HTML kodlari acisindan tablo elementleri tag'lerle belirlenmistir.
             - <table>
             - <header> tablonun baslik kismini belirler
                <tr> veya <th> satirlari
                <td> satirdaki cell numarasini verir(bunu sutun diye adlandirabiliriz ama kodlarda sutun yoktur)
             - <tbody> tablo body'si



             th headerın hucresi, td de tablodaki hucre

                incele dedigimizde table tagının altında thead olur yani baslık,
                bunun altındakilerde artık th baslığın birinci satırını veriyor.
                 td lerde baslığın hücrelerini sutunlarını veriyor.  tr den sonraki th baslığın ikinci satirını veriyor

                 head —> başlık
                 th --> 1.satır
                tr--> 1.satır-1.eleman


 */


public class C02_WebTable extends TestBaseBeforeAfter {

    //Bir class oluşturun : C02_WebTables
    //login( ) metodun oluşturun ve oturum açın.
    //https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
    //Username : manager
    //Password : Manager1!
    //table( ) metodu oluşturun
    //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
    //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    //printRows( ) metodu oluşturun //tr
    //table body’sinde bulunan toplam satir(row) sayısını bulun.
    //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    //4.satirdaki(row) elementleri konsolda yazdırın.


    @Test
    public void test1() {
        //login( ) metodun oluşturun ve oturum açın.
        login();
        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin

        //Username : manager
        //Password : Manager1!
        //table( ) metodu oluşturun
        table();
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        //printRows( ) metodu oluşturun //tr
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //4.satirdaki(row) elementleri konsolda yazdırın.


    }


    public  void login() {
        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //Username : manager
        //Password : Manager1!
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();


    }

    public void table() {
        // -- tabloda <table> tagi altinda tablonun basligini gosteren <thead> tagi bulunur
        // -- eger baslikta satir(row) varsa <thead> tagi altinda <tr> (satir-row) tagi vardir
        // -- ve basliktaki sutunlara yani hucrelere(cell) de <th> tagi ile ulasilir
        // -- basligin altindaki tablodaki verilere <tbody> tagi ile altindaki satirlara (row)
        // -- <tr> tagi ile sutunlara yani hucrelere <td> tagi ile ulasiriz

    //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("sutunSayisi= " + sutunSayisi.size());

        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement body = driver.findElement(By.xpath("//tbody"));
        System.out.println(body.getText());

        List<WebElement> sutunBasliklari = driver.findElements(By.xpath("//thead//tr//th"));
        sutunBasliklari.forEach(t -> System.out.println(t.getText()));

        //sutunSayisi.stream().map(WebElement::getText).forEach(System.out::println);

        //for (WebElement w:sutunSayisi ) {
        //    System.out.print(w.getText()+ " ");
        //}

        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println(satirSayisi.size());

        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirSayisi.forEach(t-> System.out.println(t.getText()));
        satirSayisi.stream().map(WebElement::getText).forEach(System.out::println);


        // 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println(driver.findElement(By.xpath("//tbody//tr[4]")).getText());


    }
}
