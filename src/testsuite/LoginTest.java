package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.html";

    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // sending the email and password fields
        sendTextToElement(By.name("username"),"tsel7269@gmail.com");
        //driver.findElement(By.name("password")).sendKeys("abcd123");
        sendTextToElement(By.name("password"),"abcd123");
        //clicking the login link
        clickOnElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"));
        verifyTextMethod("ErrorMessage","Accounts Overview",By.className("title"));
    }
    @Test
    public void verifyTheErrorMessage() {
          //sending the invalid email and password fields
        sendTextToElement(By.name("username"),"Tsel72875@gmail.com");
        sendTextToElement(By.name("password"),"abcdee1234");
        //clicking the login link
       clickOnElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"));
        //verifying the Error messages
        verifyTextMethod("No Matching Error Messages","The username and password could not be verified.",By.className("error"));
    }
    @Test
    public void userShouldLogOutSuccessfully() {
        //sending the email and password fields
        sendTextToElement(By.name("username"),("tsel72627@gmail.com"));
        sendTextToElement(By.name("password"),("abcd123"));
        //clicking the login link
        clickOnElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"));
        //clicking the logout link
        clickOnElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a"));
        //verifying the Customer Login text
        verifyTextMethod("Unsuccesfull Logout","Customer Login",By.xpath("//*[@id=\"leftPanel\"]/h2"));
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
