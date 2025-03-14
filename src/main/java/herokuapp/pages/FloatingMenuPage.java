package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FloatingMenuPage extends BasePage {
    public FloatingMenuPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public FloatingMenuPage scrollToCenterPage() {
        scrollToCenterPageWithJs();
        return this;
    }

    @FindBy(id = "menu")
    WebElement menu;
    public FloatingMenuPage verifyFloatingMenuIsPresent() {
        waitForPageScrollToFinish();
       // isElementPresent(menu);
        Assert.assertTrue(menu.isDisplayed(), "❌ Floating menu is not present");
        return this;
    }

    public FloatingMenuPage scrollToEndOfPage() {
        scrollToEnd();
        return this;
    }

}

