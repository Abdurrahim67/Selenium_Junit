package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FilrExists {
    @Test

    public void test1(){
      //  System.out.println(System.getProperty("user.dir"));
       // System.out.println(System.getProperty("user.home"));

        String dosyaYolu="C:\\Users\\HP-ZBook 3\\Desktop\\Neues Textdokument.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
 Bir Web sitesinden indirdigimiz yada windows icinde
 olusturdugumuz dosyanin indigini yada orda oldugunu
 test edebilmek icin o dosyanin uzerine shift tusuna
 basili olarak sag click yapip dosyanin yolunu kopyalayıp
 bir String degiskene atariz ve dosyayi dogrulamak icin
 Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
 Bu methodu kullaniriz.
*/

    }
}
