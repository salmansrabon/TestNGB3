package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LoginPage {
    @FindBy(className = "login")
    WebElement btnLogin;
    @FindBy(id = "email")
    WebElement txtEmail;
    @FindBy(id="passwd")
    WebElement txtPassword;
    @FindBy(id="SubmitLogin")
    WebElement btnSubmit;
    @FindBy(className = "logout")
    public
    WebElement btnLogout;
    @FindBy(className = "header_user_info")
    List<WebElement> lblUsername;
    @FindBy(id ="email_create")
    WebElement txtEmailReg;
    @FindBy(id="SubmitCreate")
    WebElement btnSubmitCreate;
    @FindBy(id="id_gender1")
    WebElement rb1;
    @FindBy(id="customer_firstname")
    WebElement txtFirstName;
    @FindBy(id="customer_lastname")
    WebElement txtLastName;
    @FindBy(id = "days")
    WebElement cbDate;
    @FindBy(id="months")
    WebElement cbMonths;
    @FindBy(id="years")
    WebElement cbYears;
    @FindBy(xpath = "//span[contains(text(),'Register')]")
    WebElement btnSubmitAccount;
    @FindBy(name="address1")
    WebElement txtAddress;
    @FindBy(name="city")
    WebElement txtCity;
    @FindBy(name="postcode")
    WebElement txtPostCode;
    @FindBy(name="id_state")
    WebElement cbState;
    @FindBy(name="phone_mobile")
    WebElement txtMobile;
    @FindBy(xpath = "//li[contains(text(),'Authentication failed.')]")
    WebElement lblAuthError;
    @FindBy(xpath = "//li[contains(text(),'Invalid email address')]")
    WebElement lblInvalidEmailValidationMessage;
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void doReg(String email, String password){
        btnLogin.click();
        txtEmailReg.sendKeys(email);
        btnSubmitCreate.click();
        rb1.click();
        txtFirstName.sendKeys("Test");
        txtLastName.sendKeys("User");
        txtPassword.sendKeys(password);
        Select date=new Select(cbDate);
        date.selectByValue("5");
        Select month=new Select(cbMonths);
        month.selectByValue("3");
        Select year=new Select(cbYears);
        year.selectByValue("1990");
        txtAddress.sendKeys("Alabama");
        txtCity.sendKeys("Alabama");
        txtPostCode.sendKeys("10101");
        Select option=new Select(cbState);
        option.selectByVisibleText("Alabama");
        txtMobile.sendKeys("15708898785");
        btnSubmitAccount.click();

    }
    public String doLogin(String email, String password){
        btnLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmit.click();
        return lblUsername.get(0).getText();
    }
    public String doLoginWithValidEmailandWrongPassword(String email, String password){
        btnLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmit.click();
        return lblAuthError.getText();
    }
    public String doLoginWithInvalidEmail(String email, String password){
        btnLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmit.click();
        return lblInvalidEmailValidationMessage.getText();
    }
}
