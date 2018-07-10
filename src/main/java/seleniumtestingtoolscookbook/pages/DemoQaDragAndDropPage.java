package seleniumtestingtoolscookbook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQaDragAndDropPage extends Page {


    @FindBy(id = "draggableview")
    private WebElement source;
    @FindBy(id = "droppableview")
    private WebElement target;

    public DemoQaDragAndDropPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getSource() {
        return source;
    }

    public WebElement getTarget() {
        return target;
    }
}
