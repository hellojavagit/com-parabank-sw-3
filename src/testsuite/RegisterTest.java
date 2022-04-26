package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.html";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        //clicking on the register link
       clickOnElement(By.linkText("Register"));
         //verifying the text message
        verifyTextMethod("ErrorMessage","Signing up is easy!",By.xpath("//h1[normalize-space()='Signing up is easy!']"));
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {

        // click on the ‘Register’ link
        clickOnElement(By.linkText("Register"));
        //Enter First name
        sendTextToElement(By.name("customer.firstName"), "Hello");
        //Enter Last name
        sendTextToElement(By.name("customer.password"), "Hi");
        //Enter Address
        sendTextToElement(By.id("customer.address.street"), "123TheAvenue");
        //Enter City
        sendTextToElement(By.id("customer.address.city"), "California");
        //Enter State
        sendTextToElement(By.name("customer.address.state"), "Arizona");
        //Enter Zip Code
        sendTextToElement(By.id("customer.address.zipCode"), "123456");
        //Enter Phone;
        sendTextToElement(By.name("customer.phoneNumber"), "0123432121");
        //Enter SSN
        sendTextToElement(By.name("customer.ssn"), "123456789");
        //Enter Username
        sendTextToElement(By.name("customer.username"), "tsel72845@gmail.com");
        //Enter Password field
        sendTextToElement(By.name("customer.password"), "abcd123");
        //Enter Confirm
        sendTextToElement(By.name("repeatedPassword"), "abcd123");
        //Click on REGISTER button
        clickOnElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"));
        //verifyTextMessages("Succesfull", "Your account was created successfully. You are now logged in.", By.xpath("//*[@id=\"rightPanel\"]/p"));
        verifyTextMethod("Account not created successfully","Your account was created successfully. You are now logged in.",By.xpath("//div[@id='bodyPanel']/child::div[2]/child::p"));
    }
    @After
    public void tearDown() {
       closeBrowser();
    }
}
