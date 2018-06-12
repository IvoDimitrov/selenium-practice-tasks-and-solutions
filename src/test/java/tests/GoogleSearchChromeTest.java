package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GoogleBaseTest;

import javax.annotation.Nonnull;

import static org.testng.AssertJUnit.assertEquals;

public class GoogleSearchChromeTest extends GoogleBaseTest {

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
        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(@Nonnull WebDriver d) {
                return d.getTitle().toLowerCase()
                        .startsWith("selenium");
            }
        });

        assertEquals("Selenium - Google Search",
                driver.getTitle());
    }
}