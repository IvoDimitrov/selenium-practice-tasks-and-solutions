package masteringseleniumbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverThread {

    private final String operatingSystem =
            System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture =
            System.getProperty("os.arch");
    private WebDriver webdriver;

    public WebDriver getDriver() {
        if (null == webdriver) {
            System.out.println(" ");
            System.out.println("Current Operating System: " +
                    operatingSystem);
            System.out.println("Current Architecture: " +
                    systemArchitecture);
            System.out.println("Current Browser Selection: Firefox");
            System.out.println(" ");

            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("marionette", true);
            webdriver = new FirefoxDriver(firefoxOptions);

            // webdriver = new ChromeDriver();
        }
        return webdriver;
    }

    void quitDriver() {
        if (null != webdriver) {
            webdriver.quit();
            webdriver = null;
        }
    }
}
