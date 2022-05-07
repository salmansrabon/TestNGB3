package TestRunner;

import Base.Setup;
import Pages.PurchaseProductPage;
import io.qameta.allure.Allure;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductPurchaseTestRunner extends Setup {
    @Test(priority = 5, groups = "purchase")
    public void searchProduct() throws IOException, ParseException {
        driver.get("http://automationpractice.com/");
        PurchaseProductPage purchaseProductPage=new PurchaseProductPage(driver);
        purchaseProductPage.doLogin();
        String searchMessage= purchaseProductPage.searchProduct();
        Assert.assertTrue(searchMessage.contains("results have been found"));
        Allure.description("User can search product");
    }
}
