package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HoversPage extends BasePage {
    public HoversPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//img[@alt='User Avatar'])[1]")
    public WebElement user1;

    @FindBy(xpath = "(//img[@alt='User Avatar'])[2]")
    public WebElement user2;

    @FindBy(xpath = "(//img[@alt='User Avatar'])[3]")
    public WebElement user3;

    // Наводимо курсор на зображення юзера
    public HoversPage hoverOverUser(WebElement userElement) {
        wait.until(ExpectedConditions.visibilityOf(userElement));
        Actions actions = new Actions(driver);
        actions.moveToElement(userElement).perform();
        return this;
    }

    @FindBy(xpath = "//h5[contains(text(),'name: user1')]") // Додаткова інформація для першого користувача
    public WebElement user1Info;

    @FindBy(xpath = "//h5[contains(text(),'name: user2')]")
    public WebElement user2Info;

    @FindBy(xpath = "//h5[contains(text(),'name: user3')]")
    public WebElement user3Info;

    // Перевіряємо, що додаткова інформація з'явилася
    public HoversPage checkUserInfoIsDisplayed(WebElement userInfoElement) {
        wait.until(ExpectedConditions.visibilityOf(userInfoElement));
        return this;
    }

    // Перевіряємо текст додаткової інформації
    public HoversPage checkUserInfoText(WebElement userInfoElement, String expectedText) {
        String actualText = userInfoElement.getText();
        if (actualText.contains(expectedText)) {
            System.out.println("Текст інформації вірний: " + actualText);
        } else {
            System.out.println("Текст інформації невірний. Очікувалось: " + expectedText + ", а отримано: " + actualText);
        }
        return this;
    }
}
