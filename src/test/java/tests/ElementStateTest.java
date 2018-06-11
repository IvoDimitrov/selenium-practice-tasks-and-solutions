package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.basetests.ToolsQaBaseTest;

import static junit.framework.TestCase.fail;

public class ElementStateTest extends ToolsQaBaseTest {

    @Test
    public void testElementIsEnabled() {
        // Get the Checkbox as WebElement using it's name attribute
        WebElement profession = driver.findElement(By.
                cssSelector("#profession-0"));
        // Check if its enabled before selecting it
        if (profession.isEnabled()) {
            // Check if its already selected? otherwise select the Checkbox
            if (!profession.isSelected()) {
                profession.click();
            }
        } else {
            fail("Checkbox is disabled!");
        }
    }
}
