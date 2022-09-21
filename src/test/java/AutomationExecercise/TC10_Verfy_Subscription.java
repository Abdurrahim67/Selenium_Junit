package AutomationExecercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TC10_Verfy_Subscription extends Before_After {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Scroll down to footer
    //5. Verify text 'SUBSCRIPTION'
    //6. Enter email address in input and click arrow button
    //7. Verify success message 'You have been successfully subscribed!' is visible

    @Test
    public void test() throws AWTException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.cssSelector("[class=\"logo pull-left\"]")).isDisplayed());
        //4. Scroll down to footer
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);
        //5. Verify text 'SUBSCRIPTION'
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed());
        //6. Enter email address in input and click arrow button
        driver.findElement(By.id("susbscribe_email")).sendKeys("alpcan389@gmail.com");
        driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();
        //7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement successMessage = driver.findElement(By.xpath("//*[@id='success-subscribe']"));
        Assert.assertTrue(successMessage.isDisplayed());

    }

}
