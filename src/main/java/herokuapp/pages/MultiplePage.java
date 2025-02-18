package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiplePage extends BasePage {
    public MultiplePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//a[contains(text(),'Click Here')]")
    WebElement clickHere;

    public NewWindowsPage getClickOnLinkHereClick() {
        click(clickHere);
        String mainWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle); // Переключення на нове вікно
            }
        }
        return new NewWindowsPage(driver, wait);
    }
}
