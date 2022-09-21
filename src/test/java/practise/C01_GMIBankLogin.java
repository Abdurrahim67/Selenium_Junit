package practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_GMIBankLogin {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.gmibank.com/");

        driver.findElement(By.cssSelector("[id=\"account-menu\"]")).click();

        driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Batch81");

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Batch81");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("[class=\"btn btn-secondary\"]")).click();




    }


}
