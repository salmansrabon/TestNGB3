package TestRunner;

import Base.Setup;
import Pages.LoginPage;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignupTestRunner extends Setup {
    @Test(priority = 1, groups = "signup_smoke")
    public void userReg() throws IOException, ParseException {
        driver.get("http://automationpractice.com/");
        LoginPage loginPage=new LoginPage(driver);
        int id= Utils.generateRandomId(10,1000);
        String email="user"+id+"@test.com";
        String password="P@ssword123";
        loginPage.doReg(email,password);
        Assert.assertTrue(loginPage.btnLogout.isDisplayed(), String.valueOf(true));
        Utils utils=new Utils();
        utils.saveData(email,password);
        loginPage.btnLogout.click();
    }
}
