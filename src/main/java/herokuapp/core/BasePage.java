package herokuapp.core;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

    protected static void scrollToEnd() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_END);
            robot.keyPress(KeyEvent.VK_END);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
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
private int linkCounter = 0;
    private SoftAssert softAssert = new SoftAssert();

    public void verifyLink(String urlText, String urlToCheck) {
        linkCounter++;
        try {
            URL url = new URL(urlToCheck);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                  try {
                      connection.setConnectTimeout(1000);//timeout wenn link is broukn
                      connection.setReadTimeout(1000);//timeout for reading wenn server beasy
                      connection.setRequestMethod("GET");
                     connection.connect(); //open connection

                      int responseCode = connection.getResponseCode();
                      String responseMessage = connection.getResponseMessage();
                      if (responseCode >= 400) {
                          System.err.println("❌ URL #" + linkCounter + ": [" + urlToCheck + "], response code: [" + responseCode + "], message: [" + responseMessage + "] -> Broken link");
                          softAssert.fail("❌ Broken link: [" + urlToCheck + "] Code: [" + responseCode + "] Message: [" + responseMessage + "]");
                      } else {
                          System.out.println("✅ URL #" + linkCounter + ": ["+ urlText + "], URL: [" + urlToCheck + "], response code: [" + responseCode + "], message: [" + responseMessage + "] -> Valid link");

                      }

                  } finally {
                      connection.disconnect();//close connection
                  }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void assertAll() {
        softAssert.assertAll();
    }

    public boolean isElementPresent(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("Element `"+element.getText() + "` is present: " + element.isDisplayed());
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println("Element "+element.getText() + " is not present: " + e.getMessage());
            return false;
        }
    }
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void scrollToCenterPageWithJs() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight / 2);");
    }

    protected void waitForPageScrollToFinish() {

            //* wait.until() всегда выполняется минимум два раза:
            //= Первый вызов при старте ожидания.
            //= Второй вызов для проверки условия выхода из do-while
            wait.until(driver -> { //это лямбда-выражение, которое принимает driver как аргумент и выполняет код внутри {}.
                double beforeScroll, afterScroll;
                int count = 0; // Инициализируем счётчик
                do {
                    beforeScroll = ((Number) js.executeScript("return window.scrollY;")).doubleValue();
                    System.out.println(beforeScroll);
                    pause(500); // Ждём короткий промежуток времени
                    afterScroll = ((Number) js.executeScript("return window.scrollY;")).doubleValue();
                    System.out.println(afterScroll);
                    System.out.println((++count) + "-я попытка подождать окончание скролла страницы.");
                } while (beforeScroll != afterScroll); // Если скролл ещё идёт, повторяем

                return true;
            });
        }
}
