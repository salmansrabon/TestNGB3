package TestRunner;

import Base.Setup;
import Pages.LoginPage;
import Utils.Utils;
import io.qameta.allure.Allure;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;

public class LoginTestRunner extends Setup {


    @Test(priority = 2, groups = "login_smoke")
    public void userLogin() throws InterruptedException, IOException, ParseException {
        LoginPage loginPage=new LoginPage(driver);
        driver.get("http://automationpractice.com/");
        Utils utils=new Utils();
        utils.readData(utils.getLatestUser()-1);
        String name= loginPage.doLogin(utils.getEmail(),utils.getPassword());
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(name.contains("Test User"));
        softAssert.assertTrue(loginPage.btnLogout.isDisplayed(), String.valueOf(true));
        softAssert.assertAll();
        Thread.sleep(5000);
        loginPage.btnLogout.click();
        Allure.description("User can login successfully");
    }
    @Test(priority = 3,enabled = true, groups = "login_smoke")
    public void doLoginWithValidEmailandWrongPassword() throws InterruptedException, IOException, ParseException {
        LoginPage loginPage=new LoginPage(driver);
        driver.get("http://automationpractice.com/");
        String errorMessage= loginPage.doLoginWithValidEmailandWrongPassword("salman@test.com","123456");
        Assert.assertTrue(errorMessage.contains("Authentication failed."));
        Allure.description("User can not login with invalid password");
    }
    @Test(priority = 4,enabled = true, groups = "login_smoke" )
    public void doLoginWithInvalidEmail() throws InterruptedException, IOException, ParseException {
        LoginPage loginPage=new LoginPage(driver);
        String errorMessage= loginPage.doLoginWithInvalidEmail("salman","123456");
        Assert.assertTrue(errorMessage.contains("Invalid email address"));
        Allure.description("User can not login with invalid email");
    }

}
