package Homework;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Set;

public class Map {

    //ODEV

    //Yeni bir test method olusturalim readExcel2()
    //-1.satirdaki 2.hucreye gidelim v eyazdiralim
    //-1.satirdaki 2.hucreyi bir string degiskene atayalim veyazdiralim
    //-2.satir 4.cell’in afganistan’in baskenti oldugunu testedelim
    //-Satir sayisinibulalim
    //-Fiziki olarak kullanilan satir sayisinibulun
    //-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

    @Test

    public void test() throws IOException {
        String dosyaYolu = "src/main/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);


        //-1.satirdaki 2.hucreye gidelim ve yazdiralim
        //-1.satirdaki 2.hucreyi bir string degiskene atayalim veyazdiralim
        String row1cell2 = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println("row1cell2= " + row1cell2);
        System.out.println("==================================================");

        //-2.satir 4.cell’in afganistan’in baskenti oldugunu testedelim
        String actualBaskent = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedBaskent = "Kabil";
        Assert.assertEquals(expectedBaskent, actualBaskent);

        //-Satir sayisini bulalim
        int satirSayisi = workbook.getSheet("Sayfa1").getLastRowNum() + 1;
        System.out.println("satirSayisi= " + satirSayisi);
        System.out.println("==================================================");

        //-Fiziki olarak kullanilan satir sayisini bulun
        int fizikiSatirSayisi = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("fizikiSatirSayisi=" + fizikiSatirSayisi);

        System.out.println("==================================================");

        //-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        Sheet sheet = workbook.getSheet("Sayfa1");
        int rowCount = sheet.getLastRowNum();

        java.util.Map<String, String> mapList = new LinkedHashMap<>();
        for (int i = 0; i <= rowCount; i++) {

            Row row = sheet.getRow(i);
            Cell keyCell = row.getCell(0);
            String key = keyCell.getStringCellValue();


            Cell valuCell = row.getCell(1);
            String value = valuCell.getStringCellValue();

            mapList.put(key, value);

        }

        //alt alta yazdirmak icin
        Set<java.util.Map.Entry<String, String>> entryList = mapList.entrySet();
        entryList.forEach(System.out::println);


        }




    }






