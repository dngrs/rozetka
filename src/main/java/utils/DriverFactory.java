package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Igor Odokienko
 */
public class DriverFactory {

    private static final long IMPLICIT_WAIT_TIMEOUT = 30;
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver isn'not initialized.");
        }
    }

    public static void init() {
        switch (PropertyConfig.getProperty("browser")) {
            case "firefox":
                //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/drivers/chromedriver");
                driver = new ChromeDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void close() {
        DriverFactory.getDriver().quit();
    }

    public static WebDriverWait getWait() {
        return wait == null ? new WebDriverWait(DriverFactory.getDriver(), 20) : wait;
    }

}
