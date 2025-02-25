package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyPressPage extends BasePage {
    public KeyPressPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "target")
    WebElement target;
    @FindBy(id = "result")
    WebElement result;


    public KeyPressPage pressKey(String letter) {
        try {
            if (letter == null || letter.length() != 1) {
                throw new IllegalArgumentException("❌ Only one simvole please");
            }
            // Переменная хранит символ для теста
            char character = Character.toUpperCase(letter.charAt(0));

            //Переменная хранит номер символа
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(character);

            if (keyCode == KeyEvent.VK_UNDEFINED) {//obrabotka vvoda nesywestvyuwego simvola
                throw new IllegalArgumentException("❌ Simvole " + letter + " not supported");
            }
            click(target);//zaxodim v input
            Robot robot = new Robot();
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        } catch (AWTException e) {
            throw new RuntimeException("❌ Error with robot: " + e.getMessage(), e);
        }

        return this;
    }
//✅ ❌

    public KeyPressPage verifyPressKey(String letter) {
        shouldHaveText(result, letter.toUpperCase(), 5000);
        return this;
    }
}
