package seleniumtestingtoolscookbook.utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static WebDriver webDriver;

    protected static WebDriver getWebDriver() {
        return webDriver;
    }

    // Setting up Browser Desired Capabilities
    private static void setChromeDriverProperty() {
        if (System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver",
                    "./src/test/resources/drivers/chromedriver.exe");
        } else if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("webdriver.chrome.driver",
                    "./src/test/resources/drivers/chromedriver");
        }
    }

    protected static void goToPageAndWaitPageToLoad(final String page) {
        // Go to page
        getWebDriver().get(page);
        // Wait for the page to load, timeout after 10 seconds
        new WebDriverWait(getWebDriver(), 10).
                until((ExpectedCondition<Boolean>) driver -> driver.getTitle().toLowerCase()
                        .contains(Links.getPages()
                                .get(page)));
    }

    @Before
    public void setUp() {
        setChromeDriverProperty();
        System.out.println("Starting driver...");
        webDriver = new ChromeDriver();
        // webDriver = new FirefoxDriver();
        System.out.println("Started driver.");

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        webDriver.quit();

        System.out.println();
        System.out.println("Driver quit.");
    }
}
