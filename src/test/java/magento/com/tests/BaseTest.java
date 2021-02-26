package magento.com.tests;

import magento.com.framework.Browser;
import magento.com.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    Browser browser = new Browser();
    public String chromeBrs = "chrome";
    public String geckoBrs = "gecko";
    public static final String Url = "http://138.201.197.35:81/magento1/";
    CreateAnAccount createAnAccount;
    AddProducts addProducts;
    ShoppingCart shoppingCart;
    ShippingAddress shippingAddress;
    Payment payment;

    @BeforeMethod
    public void startUp() {
    driver = browser.setUp(this.chromeBrs);
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, 20);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    createAnAccount = new CreateAnAccount(driver,wait);
    addProducts = new AddProducts(driver,wait);
    shoppingCart = new ShoppingCart(driver, wait);
    shippingAddress = new ShippingAddress(driver, wait);
    payment = new Payment(driver,wait);

    driver.get(Url);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
