package magento.com.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
    public WebDriver driver;

    public WebDriver setUp(String browser) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "gecko":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Unknown driver");
                break;
        }

        return driver;
    }
}
