package AutomationExecercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class TC12_Add_Prducts extends Before_After {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click 'Products' button
    //5. Hover over first product and click 'Add to cart'
    //6. Click 'Continue Shopping' button
    //7. Hover over second product and click 'Add to cart'
    //8. Click 'View Cart' button
    //9. Verify both products are added to Cart
    //10. Verify their prices, quantity and total price


    @Test
    public void test() throws AWTException {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.cssSelector("[class=\"logo pull-left\"]")).isDisplayed());
        //4. Click 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //5. Hover over first product and click 'Add to cart'
        Robot robot = new Robot();
        robot.mouseWheel(10);
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();
        //6. Click 'Continue Shopping' button
        driver.findElement(By.cssSelector("[data-dismiss=\"modal\"]")).click();
        //7. Hover over second product and click 'Add to cart'
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[3]")).click();
        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[text()=\"View Cart\"]")).click();
        //9. Verify both products are added to Cart
        Assert.assertTrue(driver.findElement(By.xpath("(//td[@class='cart_product'])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//td[@class='cart_product'])[2]")).isDisplayed());
        //10. Verify their prices, quantity and total price
        WebElement price1 = driver.findElement(By.xpath("(//*[@class='cart_price'])[1]"));
        Assert.assertTrue(price1.isDisplayed());
        WebElement price2 = driver.findElement(By.xpath("(//*[@class='cart_price'])[2]"));
        Assert.assertTrue(price2.isDisplayed());
        WebElement quantity1 = driver.findElement(By.xpath("(//*[@class='disabled'])[1]"));
        Assert.assertTrue(quantity1.isDisplayed());
        WebElement quantity2 = driver.findElement(By.xpath("(//*[@class='disabled'])[2]"));
        Assert.assertTrue(quantity2.isDisplayed());
        WebElement total1 = driver.findElement(By.xpath("(//*[@class='cart_total_price'])[1]"));
        Assert.assertTrue(total1.isDisplayed());
        WebElement total2 = driver.findElement(By.xpath("(//*[@class='cart_total_price'])[2]"));
        Assert.assertTrue(total2.isDisplayed());
    }
}
