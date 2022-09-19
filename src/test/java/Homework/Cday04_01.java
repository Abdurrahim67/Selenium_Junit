package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Cday04_01 {
             /*
    1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
    2- Add Element butonuna 10 kez basinız
    3- 10 kez Add element butonuna basıldığını test ediniz
    4 - Delete butonuna görünmeyene kadar basınız
    5- Delete butonunun görünmediğini test ediniz
    6- Sayfayı kapatınız
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //    2- Add Element butonuna 10 kez basinız
        WebElement addButton = driver.findElement(By.xpath("//*[text()='Add Element']"));
        for (int i = 0; i < 10; i++) {
            addButton.click();

        }

        //    3- 10 kez Add element butonuna basıldığını test ediniz
        List<WebElement> addButtonList = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        if (addButtonList.size() == 10) {
            System.out.println("10 kez= PASSED");
        } else System.out.println("10 kez= FAILED");

        Thread.sleep(2000);
        //    4 - Delete butonuna görünmeyene kadar basınız
        int ilk = 0;
        int count = 10;
        WebElement deleteButton = driver.findElement(By.xpath("//*[text()='Delete']"));

        while (ilk < count) {

            try {
                deleteButton.click();
            } catch (StaleElementReferenceException e) {
                driver.findElement(By.xpath("//*[text()='Delete']")).click();

            }
            ilk++;

        }

        //    5- Delete butonunun görünmediğini test ediniz

        WebElement anasayfa = driver.findElement(By.className("no-js"));
        String deleteButtonis = "Delete";

        if (anasayfa.getText().contains(deleteButtonis)) {
            System.out.println("delete butonu görünüyor");
        } else System.out.println("delete butonu görünmüyor");

        //    6- Sayfayı kapatınız
        driver.quit();
    }
}
