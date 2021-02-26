package magento.com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {
    WebDriverWait wait;
    WebDriver driver;

    By shoppingCartBtn = By.xpath("/html/body/div[1]/header/div[2]/div[1]/a");
    By counterNumber = By.xpath("//*[contains(@class, 'action showcart')]/span[2]/span");
    By deleteButton = By.xpath("//*[contains(@class, 'product-item-details')]/div[3]/div[2]/a");
    By OkDeleteBtn = By.xpath("/html/body/div[2]/aside[2]/div[2]/footer/button[2]");
    By proceedToCheckoutBtn = By.xpath("//*[@id=\"top-cart-btn-checkout\"]");



    public ShoppingCart(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

    }

    public void clickCartBtn() {
        WebElement shoppingCart = wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartBtn));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", shoppingCart);
        wait.until(ExpectedConditions.visibilityOfElementLocated(counterNumber));
        shoppingCart.click();


    }

    public void clickDeleteButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButton)).click();

    }

    public void confirmingDeleteProduct(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(OkDeleteBtn)).click();
    }

    public void clickCheckOutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutBtn)).click();
    }




    private void sleep(long m) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


