package magento.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Payment {
    WebDriverWait wait;
    WebDriver driver;
    By getStepTitle = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[1]");
    By billingAddressDetails = By.xpath("//*[contains(@class, 'payment-method-content')]/div[2]/div[1]/div[2]");
    By placeOrderBtn = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button");


    public Payment(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;

    }

    public String getStepTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getStepTitle)).getText();
    }

    public String getBillingItemsDetails(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(billingAddressDetails)).getText();
    }

    public void clickPlaceOrderBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderBtn)).click();
    }




}
