package magento.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAnAccount {
    WebDriverWait wait;
    WebDriver driver;
    By createAccount = By.xpath("//ul[@class = 'header links']/li[3]");
    By header = By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span");
    By headerTitle = By.xpath("//*[@id=\"form-validate\"]/fieldset[1]/legend/span");
    By firstName = By.xpath("//*[@id=\"firstname\"]");
    By lastName = By.xpath("//*[@id=\"lastname\"]");
    By signUpCheckBox = By.xpath("//*[@id=\"is_subscribed\"]");
    By signInHeader = By.xpath("//*[@id=\"form-validate\"]/fieldset[2]/legend/span");
    By email = By.xpath("//*[@id=\"email_address\"]");
    By password = By.xpath("//*[@id=\"password\"]");
    By confirmPass = By.xpath("//*[@id=\"password-confirmation\"]");
    By createAccountBtn = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");
    By myAccountPageTitle = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[1]/h1/span");
    By accountInfo = By.xpath("//div[@class = 'block block-dashboard-info']/div/strong");
    By contactInfo = By.xpath("//div[@class= 'block block-dashboard-info']/div[2]/div/strong/span");
    By fullNameAndEmail = By.xpath("//div[@class= 'block block-dashboard-info']/div[2]/div[1]/div/p");


    public CreateAnAccount(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;

    }

    public void clickCreateAccountLink(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(createAccount)).click();

    }

    public String getPageHeader(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(header)).getText();
    }

    public String getHeaderTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(headerTitle)).getText();
    }

    public void enterFirstName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(name);

    }

    public void enterLastName(String last_name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(last_name);

    }

    public void clickSignUpForNewsletter(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpCheckBox)).click();
    }

    public String getSignInHeader(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(signInHeader)).getText();
    }

    public void enterEmail(String mail){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(mail);

    }

    public void enterPassword(String pass){
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
    }

    public void enterConfirmPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPass)).sendKeys(password);

    }

    public void clickCreateAccountBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(createAccountBtn)).click();
    }

    public String getMyAccountHeader(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountPageTitle)).getText();
    }

    public String getAccountInfo(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountInfo)).getText();
    }

    public String getContactInfo(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactInfo)).getText();
    }

    public String getFullNameAndEmail(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameAndEmail)).getText();
    }

    private void sleep(long m){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
