package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class DropdownPage extends BasePage {
    public DropdownPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id="dropdown")
    WebElement dropdown;

    // Метод для вибору опції за текстом
    public DropdownPage printAllOptions() {
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        System.out.println("Available options:");
        for (WebElement opt : options) {
            System.out.println(opt.getText());
        }
        return this;
    }
    public DropdownPage selectAndVerifyAllOptions() {
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            String optionText = option.getText();
            select.selectByVisibleText(optionText);
            String selectedOption = select.getFirstSelectedOption().getText();
            Assert.assertEquals(optionText, selectedOption, "Selected option does not match expected option");
        }
        return this;
    }

    // Метод для негативного тесту (спроба вибрати неіснуючу опцію)
    public DropdownPage selectNegativeExistentOption(String optionText) {
        Select select = new Select(dropdown);
        try {
            select.selectByVisibleText(optionText);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        return this;
    }



}

