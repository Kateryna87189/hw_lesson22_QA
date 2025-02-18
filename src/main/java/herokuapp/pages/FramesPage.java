package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FramesPage extends BasePage {
    public FramesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(tagName = "frame")
    List<WebElement> frames;

    public FramesPage getListOfFrames() {
        int numberOfFrames = ((Long) js.executeScript("return window.frames.length")).intValue();
        //System.out.println("Number of frames: " + numberOfFrames);
        if (frames == null || frames.isEmpty()) {
            System.out.println("No frames found");
            return this;
        }
        System.out.println("Number of frames: " + numberOfFrames);
        System.out.println("Number of frames: " + frames.size());
        for (WebElement frame : frames) {
            String frameId = frame.getAttribute("id");
            String frameSrc = frame.getAttribute("src");
            System.out.println("Frame found ID: " +
                    (frameId != null ? frameId : "No ID") + " SRC: " + (frameSrc != null ? frameSrc : "No SRC"));

        }
        return this;
    }

    public FramesPage switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }

    public FramesPage switchToFrameByFrameName(String parent, String child) {
        driver.switchTo().defaultContent();// выходим из всех фреймов
        // если родительский фрейм существует (не "*"), переключаемся на него
        if (!parent.equals("*")) {
            driver.switchTo().frame(parent); // переключаемся в родительский frame
        }
        driver.switchTo().frame(child); // переключаемся в frame-right

        return this;
    }
}
