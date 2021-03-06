package elementalseleniumcom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HighlightElement {

  private WebDriver driver;
  private JavascriptExecutor js;

  @Before
  public void setUp() {
    // Set path of drivers executable
    System.setProperty("webdriver.chrome.driver",
            "./src/test/resources/drivers/chromedriver");
    System.setProperty("webdriver.gecko.driver",
            "./src/test/resources/drivers/geckodriver");
    System.setProperty("webdriver.opera.driver",
            "./src/test/resources/drivers/operadriver");

    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
  }

  private void highlightElement(WebElement element, int duration) throws InterruptedException {
    String original_style = element.getAttribute("style");

    js.executeScript(
            "arguments[0].setAttribute(arguments[1], arguments[2])",
            element,
            "style",
            "border: 2px solid red; border-style: dashed;");

    if (duration > 0) {
      Thread.sleep(duration * 1000);
      js.executeScript(
              "arguments[0].setAttribute(arguments[1], arguments[2])",
              element,
              "style",
              original_style);
    }
  }

  @Test
  public void highlightElementTest() throws InterruptedException {
    driver.get("http://the-internet.herokuapp.com/large");
    driver.manage().window().maximize();
    WebElement element = driver.findElement(By.id("sibling-2.3"));
    highlightElement(element, 3);
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}
