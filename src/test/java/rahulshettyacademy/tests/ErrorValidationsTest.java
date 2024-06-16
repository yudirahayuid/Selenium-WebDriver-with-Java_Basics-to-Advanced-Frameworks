package rahulshettyacademy.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

import java.util.List;

public class ErrorValidationsTest extends BaseTest {

    @Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
    public void LoginErrorValidation() {

        landingPage.loginApplication("yudirahayu321@gmail.com", "Okt0ber8");
        Assert.assertEquals("Incorrect email password.", landingPage.getErrorMessage());
    }

    @Test
    public void ProductErrorValidation() throws InterruptedException {

        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("yudirahayu321@gmail.com", "Okt0ber8@");
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);
    }
}
