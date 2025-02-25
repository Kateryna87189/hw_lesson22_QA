package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public static final String HOME_PAGE_URL = "https://the-internet.herokuapp.com";
    @FindBy(xpath="//a[contains(text(),'Form Authentication')]")
     WebElement formAuthentication;

public LoginPage getFormAuthentication() {
        click(formAuthentication);
        return new LoginPage(driver, wait);
    }

    @FindBy(xpath="//a[normalize-space(text())='Nested Frames']")
    WebElement nestedFrames;
    public BasePage getNestedFrames() {
    //scrollTo(800);
        click(nestedFrames);
        return new BasePage(driver, wait);
    }

@FindBy(xpath="//a[normalize-space(text())='Multiple Windows']")
    WebElement multipleWindows;
    public BasePage getMultipleWindows() {
        click(multipleWindows);
        return new BasePage(driver, wait);
    }

    @FindBy(xpath="//a[contains(text(),'Dropdown')]")
    WebElement dropdownLink;
    public BasePage getDropdownPage() {
        click(dropdownLink);
        return new DropdownPage(driver, wait);
    }
}
