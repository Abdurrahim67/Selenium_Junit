package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    //1)Yeni bir Class olusturalimWriteExcel
    //2)Yeni bir test method olusturalimwriteExcelTest()
    //3)Adimlari takip ederek 1.satira kadar gidelim
    //4)4.hucreye yeni bir cell olusturalim
    //5)Olusturdugumuz hucreye “Nufus” yazdiralim
    //6)2.satir nufus kolonuna 1500000 yazdiralim
    //7)10.satir nufus kolonuna 250000 yazdiralim
    //8)15.satir nufus kolonuna 54000  yazdiralim
    //9)Dosyayi kaydedelim
    //10)Dosyayikapatalim

    @Test
    public void test() throws IOException {
        String dosyaYolu = "src/main/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        //3)Adimlari takip ederek 1.satira kadar gidelim
        //4)5.hucreye yeni bir cell olusturalim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4);

        //5)Olusturdugumuz hucreye “Nufus” yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        //6)2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).getCell(4).setCellValue(1500000);
        //7)10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).getCell(4).setCellValue(250000);
        //8)15.satir nufus kolonuna 54000  yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).getCell(4).setCellValue(5400);
        //9)Dosyayi kaydedelim
        workbook.write(fos);
        //Excel dosyasina veri girisi yaptiktan sonra,dosyayi akisa aldigimiz gibi sonlandirmamiz gerekir,
        // sonrasinda da workbook objemize kayit etmemiz gerekir

        fis.close();
        fos.close();
        workbook.close();

        //10)Dosyayikapatalim


    }


}
