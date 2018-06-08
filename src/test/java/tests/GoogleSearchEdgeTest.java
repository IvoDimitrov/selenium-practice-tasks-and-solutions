package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nonnull;

import static helpermethods.GetCurrentExecutableTestName.printCurrentExecutableTestName;
import static org.junit.Assert.assertEquals;

public class GoogleSearchEdgeTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Microsoft WebDriver Release 15063
        // Version: 4.15063 | Edge version supported: 15.15063
        // More driver versions: https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
        // Setting up Browser Desired Capabilities
        System.setProperty("webdriver.edge.driver",
                ".\\src\\test\\resources\\drivers\\microsoftwebdriver.exe");

        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy("eager");

        // Launch a new Edge instance
        System.out.println("Starting driver...");

        driver = new EdgeDriver(options);

        System.out.println("Started driver.");

        // Maximize the browser window
        driver.manage().window().maximize();
        // Navigate to page
        driver.get("http://www.google.com/ncr");
    }

    @Test
    public void testGoogleSearch() {
        printCurrentExecutableTestName();

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));
        // Clear the existing text value
        element.clear();
        // Enter something to search for
        element.sendKeys("Selenium testing tools cookbook");
        // Now submit the form
        element.submit();
        // Google's search is rendered dynamically with JavaScript.
        // wait for the page to load, timeout after 10 seconds
        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(@Nonnull WebDriver d) {
                return d.getTitle().toLowerCase()
                        .startsWith("selenium testing tools cookbook");
            }
        });

        assertEquals("Selenium testing tools cookbook - Google Search",
                driver.getTitle());

        System.out.println("Test passed.");
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();

        System.out.println();
        System.out.println("Driver is quited.");
    }
}