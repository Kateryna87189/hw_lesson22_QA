package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Dropdown1Page extends BasePage {
    public Dropdown1Page(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
@FindBy(id="dropdown")
WebElement dropdown;

    public Dropdown1Page selectOptionByText(String optionText) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(optionText);
        return this;
    }

    public Dropdown1Page verifySelectedOption(String expectedText) {
Select select = new Select(dropdown);
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println(selectedOption.getText());
       // Assert.assertEquals(selectedOption.getText(), expectedText);
        shouldHaveText(selectedOption, expectedText, 500);
        return this;
    }


    public Dropdown1Page selectOptionByValue(String optionValue) {
        Select select = new Select(dropdown);
        select.selectByValue(optionValue);

        return this;
    }

    public Dropdown1Page selectOptionByIndex(int index) {
        Select select = new Select(dropdown);
        select.selectByIndex(index);


        return this;
    }
}
