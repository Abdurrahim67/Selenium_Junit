package Homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class D18_WebTables extends TestBaseBeforeAfter {

    //ÖDEV 1

    //Bir class oluşturun : D18_WebTables
    //login( ) metodun oluşturun ve oturum açın.
    //https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
    //Username : manager  ○ Password : Manager2!
    //table( ) metodu oluşturun
    //Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
    //Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
    //printRows( ) metodu oluşturun //tr
    //table body’sinde bulunan toplam satir(row) sayısını bulun.
    //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    //4.satirdaki(row) elementleri konsolda yazdırın.
    //printCells( ) metodu oluşturun //td
    //table body’sinde bulunan toplam hücre(cell) sayısını bulun.
    //Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
    //printColumns( ) metodu oluşturun
    //table body’sinde bulunan toplam sutun(column) sayısını bulun.
    //Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
    //5.column daki elementleri konsolda yazdırın.

    @Test

    public void test() {
        //https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        driver.get("https://qa-environment.concorthotel.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();

        //login( ) metodun oluşturun ve oturum açın.
        login();

        //table( ) metodu oluşturun
        table();


        //printRows( ) metodu oluşturun //tr
        printRows();
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //4.satirdaki(row) elementleri konsolda yazdırın.
        //printCells( ) metodu oluşturun //td
        //table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        //Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        //printColumns( ) metodu oluşturun
        //table body’sinde bulunan toplam sutun(column) sayısını bulun.
        //Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        //5.column daki elementleri konsolda yazdırın.


    }


    private void login() {
        //Username : manager  ○ Password : Manager1!
        driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys("manager");
        actions.sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

    }

    private void table() {
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun sayisi= " + sutunSayisi.size());
        //Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        WebElement body = driver.findElement(By.xpath("//tbody"));
        System.out.println("body= " + body.getText());

        sutunSayisi.forEach(t -> System.out.println(t.getText()));


    }

    private void printRows() {

        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satirSayaisi= " + satirSayisi.size());
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirSayisi.stream().map(WebElement::getText).forEach(System.out::println);
        //4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println(driver.findElement(By.xpath("//tbody//tr[4]")).getText());
        //printCells( ) metodu oluşturun //td
        printCells();



    }

    private void printCells() {

        //table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> hücreSayisi = driver.findElements(By.xpath("//tbody//tr//td"));
        System.out.println("hücreSayisi= " + hücreSayisi.size());

        //Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        //1.yol
        hücreSayisi.forEach(t -> System.out.println(t.getText()));
        //2.yol
        hücreSayisi.stream().map(WebElement::getText).forEach(System.out::println);
        //3.yol
        for (WebElement w : hücreSayisi) {
            System.out.println(w.getText());

        }
        //printColumns( ) metodu oluşturun
        printColumns();

    }

    private void printColumns() {
        //table body’sinde bulunan toplam sutun(column) sayısını bulun.
        List<WebElement> tbodySutunsayisi = driver.findElements(By.xpath("//table//tbody//tr[1]//td"));
        System.out.println("tbodySutunsayisi="+tbodySutunsayisi.size());
        //Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        List<WebElement>tbodySutunlar=driver.findElements(By.xpath("//table//tbody//tr//td"));
        for (WebElement w:tbodySutunlar
             ) {
            System.out.println(w.getText());

        }


        //5.column daki elementleri konsolda yazdırın.
        List<WebElement> besinciColumn = driver.findElements(By.xpath("//table//tbody//tr//td[5]"));
        besinciColumn.stream().map(WebElement::getText).forEach(System.out::println);



    }
}



