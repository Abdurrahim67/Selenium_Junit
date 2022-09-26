package Homework;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Cday14_ReadExcel{
    //-Dosya yolunu bir String degiskene atayalim
    //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    //-WorkbookFactory.create(fileInputStream)
    //-sayfa 2'ye gidip satir sayisinin 6, kullanilan stun sayisinin ise 3 oldugunu test edin

    @Test
    public void test() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/main/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook wb= WorkbookFactory.create(fis);
        //-sayfa 2'ye gidip satir sayisinin 6, kullanilan sutun sayisinin ise 3 oldugunu test edin
        Sheet sheet=wb.getSheet("Sayfa2");
        int satirSayisi=sheet.getLastRowNum()+1;
        Row row=sheet.getRow(satirSayisi-1);
        int sutunSayisi= row.getLastCellNum();

        Assert.assertEquals(satirSayisi,6);
        Assert.assertEquals(sutunSayisi,3);


    }
}
