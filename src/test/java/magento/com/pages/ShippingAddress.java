package magento.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingAddress {
    WebDriverWait wait;
    WebDriver driver;

    By e_mail = By.xpath("//*[@id=\"customer-email\"]");
    //By firstName = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[1]/div/input");
    //By last_Name = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[2]/div/input");
    By companyLoc = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[3]/div/input");
    By streetAddress = By.xpath("//*[@id=\"shipping-new-address-form\"]/fieldset/div/div[1]/div/input");
    By cityLoc = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[4]/div/input");
    By state = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[5]/div/select");
    By zipCode = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[7]/div/input");
    By countryLoc = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[8]/div/select");
    By phoneLoc = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[9]/div/input");
    By nextButton = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button");
    public ShippingAddress(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterEmail(String mail) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(e_mail)).sendKeys(mail);

    }

   /* public void enterFirstName(String name) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(name);

    }*/

    /*public void enterLastName(String lastName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(last_Name)).sendKeys(lastName);
    }*/

    public void enterCompany(String company){
        wait.until(ExpectedConditions.visibilityOfElementLocated(companyLoc)).sendKeys(company);

    }

    public void enterStreetAddress(String address){
        wait.until(ExpectedConditions.visibilityOfElementLocated(streetAddress)).sendKeys(address);

    }

    public void enterCity(String city){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityLoc)).sendKeys(city);

    }

    public void selectState(String text){
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(state)));
        select.selectByVisibleText(text);

    }

    public void enterZipCode(int code){
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode)).sendKeys(""+code);

    }

    public void selectCountry(String country){
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(countryLoc)));
        select.selectByVisibleText(country);
    }

    public void enterNumber(int number){
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneLoc)).sendKeys("" + number);

    }

    public void clickNextBtn(){
        WebElement nextBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", nextBtn);
        nextBtn.click();
    }

private void sleep(long m){
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

}

