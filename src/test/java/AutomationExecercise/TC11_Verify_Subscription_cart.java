package AutomationExecercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TC11_Verify_Subscription_cart extends Before_After {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click 'Cart' button
    //5. Scroll down to footer
    //6. Verify text 'SUBSCRIPTION'
    //7. Enter email address in input and click arrow button
    //8. Verify success message 'You have been successfully subscribed!' is visible


    @Test
    public void test() throws AWTException {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.cssSelector("[class=\"logo pull-left\"]")).isDisplayed());
        //4. Click 'Cart' button
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();
        //5. Scroll down to footer
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);
        //6. Verify text 'SUBSCRIPTION'
        Assert.assertTrue(driver.findElement(By.tagName("h2")).isDisplayed());
        //7. Enter email address in input and click arrow button
        driver.findElement(By.id("susbscribe_email")).sendKeys("alpcan389@gmail.com", Keys.ENTER);
        //8. Verify success message 'You have been successfully subscribed!' is visible
        WebElement successMessage = driver.findElement(By.xpath("//*[@id='success-subscribe']"));
        Assert.assertTrue(successMessage.isDisplayed());


    }
}
