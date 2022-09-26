package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    //- Dosya yolunu bir String degiskene atayalim
    //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    //- WorkbookFactory.create(fileInputStream)
    //- Sheet objesi olusturun workbook.getSheetAt(index)
    //- Row objesi olusturun sheet.getRow(index)
    //- Cell objesi olusturun row.getCell(index)
    //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin

    @Test
    public void readExcel() throws IOException {
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/main/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);//Olusturmus oldugumuz dosyayi sisteme alir

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook=WorkbookFactory.create(fis);// Workbook objesiyle fis objesi ile akisa aldigimiz dosyamizla bir excel dosyasi creat ettik

        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet=workbook.getSheet("Sayfa1");//Excel dosyamizda calismak istedigimiz sayfayi bu sekilde seceriz

        //- Row objesi olusturun sheet.getRow(index)
        Row row= sheet.getRow(3);//sayfa 1 deki 3.satiri bu sekilde seceriz

        //- Cell objesi olusturun row.getCell(index)
        Cell cell= row.getCell(3);//Satir secimi yapildiktan sonra hücre secimi bu sekilde yapilir
        System.out.println(cell);

        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
        String expectedData="Cezayir";
        String actualData=cell.toString();
        Assert.assertEquals(expectedData,actualData);
        Assert.assertEquals(expectedData,cell.getStringCellValue());



    }
}

/*
Exceldeki bir dosyaya ve dosyadaki bir bölüme ulaşmak istediğimizde
uygulayacağımız aşamalar :
Ara-->dosyaYolu      --> String dosyaYolu="src/resources/ulkeler.xlsx";
Windows Gezgini ile ac- ->FileInputStream    --> FileInputStream fis = new FileInputStream(dosyaYolu);
Excel i ac              -->Workbook        --> Workbook workbook = WorkbookFactory.create(fis)
workbook olusturduktan sonra :
String actualData = workbook.
                getSheet("Sayfa1")
                .getRow(3)
                .getCell(3)
                .toString();
Sayfa1 e git-->Sheet    --> getSheet()
Satiri bul-->Row       --> getRow()
Sutunu bul-->Cell     --> getCell()
Secilen bolumu getir  --> toString()
 */


