package AutomationExecercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC01_Register_User {
    public static void main(String[] args) throws InterruptedException {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homepage = driver.findElement(By.xpath("//*[@class='col-sm-6']"));
        boolean homepageIsDisplayed = homepage.isDisplayed();
        System.out.println("homepageDisplayed = " + homepageIsDisplayed);
        Thread.sleep(2000);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();


        Thread.sleep(1000);
        //5. Verify 'New User Signup!' is visible
        boolean newUserSignupIsDisplayed = driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed();
        System.out.println("newUserSignupIsDisplayed = " + newUserSignupIsDisplayed);

        //6. Enter name and email address
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Alp Can");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("alpcan359@gmail.com");
        Thread.sleep(2000);
        // 7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();
        Thread.sleep(2000);
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        boolean enterAccountInformationIsDisplayed = driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed();
        System.out.println("enterAccountInformationIsDisplayed = " + enterAccountInformationIsDisplayed);

        //9. Fill details: Title, Name, Email, Password, Date of birth
        //a.Title
        driver.findElement(By.xpath("//*[@for='id_gender1']")).click();
        Thread.sleep(2000);
        //b.Email, Password
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("alpcan");

        //c. Date of birth

        driver.findElement(By.xpath("//*[@id='days']")).sendKeys("10");
        driver.findElement(By.xpath("//*[@id='months']")).sendKeys("8");
        driver.findElement(By.xpath("//*[@id='years']")).sendKeys("1990");



        //10. Select checkbox 'Sign up for our newsletter!
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        Thread.sleep(1000);

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@name='optin']")).click();
        Thread.sleep(1000);
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("Alp");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("Can");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("TechPro");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("Karl street");
        driver.findElement(By.xpath("//*[@id='address2']")).sendKeys("Wall22");
        Thread.sleep(1000);
        // driver.findElement(By.xpath("//*[@id='country']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Canada']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("165.state");
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Sydney");
        driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys("657");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='mobile_number']")).sendKeys("014265846");
        Thread.sleep(1000);


        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();
        //14. Verify that 'ACCOUNT CREATED!' is visible
        System.out.println("ACCOUNT CREATED!= " + driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed());
        Thread.sleep(3000);
        //15. Click 'Continue' button
        driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
        Thread.sleep(1000);

        //16. Verify that 'Logged in as username' is visible
        System.out.println("Logged in as username" + driver.findElement(By.xpath("//*[text()=' Logged in as '] ")).isDisplayed());
        Thread.sleep(1000);

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String sonuc = driver.findElement(By.xpath("(//*[@class='container'])[2]")).getText();
        if (sonuc.contains("ACCOUNT DELETED!")) {
            System.out.println("ACCOUNT DELETED!= PASSED");
        } else System.out.println("ACCOUNT DELETED!= FAILED");
        Thread.sleep(5000);

        driver.quit();



    }

}
