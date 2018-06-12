package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

import static junit.framework.TestCase.fail;

public class ElementPresenceTest extends BaseTest {

    private boolean isElementPresent(By by) {
        try {
            getWebDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Test
    public void testIsElementPresent() {
        // Check if element with locator criteria exists on Page
        if (isElementPresent(By.
                cssSelector("#profession-0"))) {
            // Get the checkbox and select it
            WebElement professionManualTesterCheckBox = getWebDriver().findElement(By.
                    cssSelector("#profession-0"));
            if (!professionManualTesterCheckBox.isSelected()) {
                professionManualTesterCheckBox.click();
            }
        } else {
            fail("Profession Manual tester Checkbox doesn't exists!!");
        }
    }
}