package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewWindowsPage extends BasePage {
    public NewWindowsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//h3[normalize-space(text())='New Window']")
    WebElement newWindowText;

    public NewWindowsPage verifyText(String text) {
        wait.until(ExpectedConditions.visibilityOf(newWindowText));

        shouldHaveText(newWindowText, text, 500);
        driver.close();
        return this;
    }
}
