package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class CheckBoxPage extends BasePage {
    public CheckBoxPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//form[@id='checkboxes']/input")
    List<WebElement> checkBoxes;

    public CheckBoxPage printCheckBox() {
        String labelText;
        for (WebElement checkBox : checkBoxes){
             labelText = chooseCheckBoxByName(checkBox);
            System.out.println("CheckBox text: " + labelText);
        }

        return this;
    }

    private String chooseCheckBoxByName(WebElement checkBox) {
        return (String) js.executeScript("return arguments[0].nextSibling.textContent;", checkBox);
    }

    public CheckBoxPage selectCheckBoxByText(String checkBoxText) {
        String labelText;
        for (WebElement checkBox : checkBoxes) {
            labelText = chooseCheckBoxByName(checkBox);
            if (labelText.trim().equals(checkBoxText)){
                if (!checkBox.isSelected()) {
                    checkBox.click();
                }else if (checkBox.isSelected()){
                    System.out.println("CheckBox is already selected");
                }
                return this;
            }
        }
        return this;
    }

    public CheckBoxPage verifyCheckBox(String checkBoxText) {
        String labelText;
        for (WebElement checkBox : checkBoxes){
            labelText = chooseCheckBoxByName(checkBox);
            if (labelText.trim().equals(checkBoxText)){
                Assert.assertTrue(checkBox.isSelected());
                return this;
            }
        }
        return this;
    }

    public CheckBoxPage selectCheckBoxByTextWithActions(String checkBoxText) {

            Actions actions = new Actions(driver);
            String labelText;
            for (WebElement checkBox : checkBoxes) {
                labelText = chooseCheckBoxByName(checkBox);
                if (labelText.trim().equals(checkBoxText)) {
                    if (!checkBox.isSelected()) {
                        actions.moveToElement(checkBox).click().perform();
                        System.out.println("Checkbox selected: [" + checkBoxText +"]");
                    } else if (checkBox.isSelected()) {
                        System.out.println("Checkbox already selected");
                    }
                    return this;
                }
            }
            return this;

    }

    public CheckBoxPage selectCheckBoxByTextWithRobot(String checkBoxText) {

        String labelText;
        for (WebElement checkBox : checkBoxes) {
            labelText = chooseCheckBoxByName(checkBox);
            if (labelText.trim().equals(checkBoxText)) {
                if (!checkBox.isSelected()) {
                    try {
                        Robot robot = new Robot();//vubor checkbox
                        Actions actions = new Actions(driver);
                        actions.moveToElement(checkBox).perform();
                        robot.keyPress(KeyEvent.VK_TAB);
                        robot.keyRelease(KeyEvent.VK_TAB);
                        robot.keyPress(KeyEvent.VK_TAB);
                        robot.keyRelease(KeyEvent.VK_TAB);
                        robot.delay(1000);//zalipanie klaviw
                        robot.keyPress(KeyEvent.VK_SPACE);
                        robot.keyRelease(KeyEvent.VK_SPACE);
                        System.out.println("Checkbox selected: [" + checkBoxText +"]");
                    } catch (AWTException e) {
                       Assert.fail("Fail "+checkBoxText);
                    }

                } else if (checkBox.isSelected()) {
                    System.out.println("Checkbox already selected");
                }
                return this;
            }
        }
        return this;
    }
}
