package AutomationExecercise;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class TC13_Verify_Product extends Before_After {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click 'View Product' for any product on home page
    //5. Verify product detail is opened
    //6. Increase quantity to 4
    //7. Click 'Add to cart' button
    //8. Click 'View Cart' button
    //9. Verify that product is displayed in cart page with exact quantity


    @Test
    @Ignore
    public void test() throws AWTException {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.cssSelector("[class=\"logo pull-left\"]")).isDisplayed());
        //4. Click 'View Product' for any product on home page
        Robot robot = new Robot();
        robot.mouseWheel(8);
        driver.findElement(By.xpath("//a[@href=\"/product_details/1\"]")).click();
        //5. Verify product detail is opened
        Assert.assertTrue(driver.findElement(By.className("product-information")).isDisplayed());
        //6. Increase quantity to 4
        driver.findElement(By.xpath("//*[@id=\"quantity\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"quantity\"]")).sendKeys("4");
        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@type='button']")).click();
        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        //9. Verify that product is displayed in cart page with exact quantity
        WebElement quantity = driver.findElement(By.className("disabled"));
        Assert.assertTrue(quantity.getText().contains("4"));
    }
}
