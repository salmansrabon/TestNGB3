package Pages;

import Pages.LoginPage;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class PurchaseProductPage {
    @FindBy(id = "search_query_top")
    WebElement txtSearch;
    @FindBy(name = "submit_search")
    WebElement btnSubmitSearch;

    @FindBy(className = "heading-counter")
    WebElement lblSearchMessage;
    WebDriver driver;
    public PurchaseProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void doLogin() throws IOException, ParseException {
        LoginPage loginPage=new LoginPage(driver);
        Utils utils=new Utils();
        utils.readData(utils.getLatestUser()-1);
        loginPage.doLogin(utils.getEmail(),utils.getPassword());
    }
    public String searchProduct(){
        txtSearch.sendKeys("Dress");
        btnSubmitSearch.click();
        return lblSearchMessage.getText();
    }

}
