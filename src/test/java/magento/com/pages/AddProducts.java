package magento.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProducts {
    WebDriverWait wait;
    WebDriver driver;
    By category = By.xpath("//*[contains(@class, 'navigation')]/ul/li");
    By shirts = By.linkText("shirts");
    By product1 = By.xpath("//*[@id=\"maincontent\"]/div[4]/div[1]/div[3]/ol/li");
    By productQnt = By.xpath("//*[@id=\"qty\"]");
    By addToCartBtn = By.xpath("//*[@id=\"product-addtocart-button\"]");
    By productDropdown = By.xpath("//*[@id=\"attribute149\"]");


    public AddProducts(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

    }

    public void selectCategory(int index) {
        Actions actions = new Actions(driver);
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(category)).get(index)).perform();

    }

    public void clickShirts() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(shirts)).click();
    }

    public void addToCartProducts1(int index) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(product1)).get(index).click();

    }


    public void enterQuantity(int number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productQnt)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productQnt)).sendKeys("" + number);

    }

    public void clickAddToCartBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn)).click();
        sleep(2000);
        driver.navigate().back();

    }

    public void selectDropDown(String size) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(productDropdown)));
        select.selectByVisibleText(size);

    }


    private void sleep(long m) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
