package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Cday04_03 {

    //) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
    //2) London’u 3 farkli relative locator ile locate edin 3
    //) Relative locator’larin dogru calistigini test edin

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        WebElement warsaw = driver.findElement(By.id("pid1_thumb"));
        WebElement boston = driver.findElement(By.id("pid6_thumb"));
        WebElement london = driver.findElement(RelativeLocator.with(By.tagName("img")).below(warsaw).toLeftOf(boston));
        london.click();

        WebElement bostonWe = driver.findElement(By.id("pid6_thumb"));
        WebElement warsawWe = driver.findElement(By.id("pid1_thumb"));
        WebElement toronto=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(warsawWe).above(bostonWe));
        toronto.click();



    }

}
