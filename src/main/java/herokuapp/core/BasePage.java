package herokuapp.core;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.js = (JavascriptExecutor) driver;

        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void typeWithJs(WebElement element, String text, int x, int y) {
        if (text != null) {
            js.executeScript("window.scrollBy("+x+","+y+")");
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }
    public void clickWithJs(WebElement element, int x, int y){
        js.executeScript("window.scrollBy("+x+","+y+")");
        click(element);
    }
    public void scrollTo(int y){

        js.executeScript("window.scrollBy(0,"+y+")");
    }

    public void hideAds() {
        js.executeScript("document.getElementById('adplus-anchor')");
        js.executeScript("document.querySelector('footer')");
    }
    public String takeScreenshot() {

        // Capture screenshot
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("src/test_screenshots/screen-" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Screenshot saved to: [" + screenshot.getAbsolutePath() + "]");
        return screenshot.getAbsolutePath();
    }

    protected void shouldHaveText(WebElement element, String text, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
        try {
            boolean isTextPresent = wait.until(ExpectedConditions.textToBePresentInElement(element, text));
            Assert.assertTrue(
                    isTextPresent, "Expected text: + ["+text+"], actual in element: " +
                            "["+element.getText()+"] in ["+element.getTagName()+"]");
        } catch (TimeoutException e) {
            throw new AssertionError(
                    "Text not found in element: [" + element.getTagName() + "], expected text: [" + text + "], " +
                            "was text: [" + element.getText() + "]");
        }
    }
}
