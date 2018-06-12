package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;
import utils.Links;

import javax.annotation.Nonnull;

import static org.testng.AssertJUnit.assertEquals;

public class DragDropTest extends BaseTest {

    @Test
    public void testDragDrop() {
        //Go to page
        getWebDriver().get(Links.DRAG_DROP_PAGE);

        // Wait for the page to load, timeout after 10 seconds
        new WebDriverWait(getWebDriver(), 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(@Nonnull WebDriver d) {
                return d.getTitle().toLowerCase()
                        .startsWith("droppable");
            }
        });

        WebElement source = getWebDriver().findElement(By.id("draggableview"));
        WebElement target = getWebDriver().findElement(By.id("droppableview"));

        Actions builder = new Actions(getWebDriver());
        builder.dragAndDrop(source, target).perform();
        assertEquals("Dropped!", target.getText());
    }
}
