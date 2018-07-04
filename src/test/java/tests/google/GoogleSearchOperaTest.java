package tests.google;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static utils.Links.GOOGLE_PAGE;

public class GoogleSearchOperaTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Setting up Browser Desired Capabilities
        System.setProperty("webdriver.opera.driver",
                ".\\src\\test\\resources\\drivers\\operadriver.exe");
        OperaOptions options = new OperaOptions();
        options.setBinary(new File("C:\\Program Files\\Opera\\launcher.exe"));


        // Launch a new Opera instance
        System.out.println("Starting driver...");

        driver = new OperaDriver(options);

        System.out.println("Started driver.");

        // Maximize the browser window
        driver.manage().window().maximize();
        // Navigate to page
        driver.get(GOOGLE_PAGE);
    }

    @Test
    public void testGoogleSearch() {
        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));
        // Clear the existing text value
        element.clear();
        // Enter something to search for
        element.sendKeys("Selenium");
        // Now submit the form
        element.submit();
        // Google's search is rendered dynamically with JavaScript.
        // wait for the page to load, timeout after 10 seconds
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> d.getTitle().toLowerCase()
                .startsWith("selenium"));

        assertEquals("Selenium - Google Search",
                driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        // Close the browser
        driver.quit();

        System.out.println();
        System.out.println("Driver quit.");
        // Opera browser does not close. Solution for windows:
        Runtime.getRuntime().exec("taskkill /f /im opera.exe");
        // For MacOS:
        // Runtime.getRuntime().exec("pgrep 'Opera' | xargs kill");
    }
}