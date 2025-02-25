package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddRemoveElementsPage extends BasePage {
    public AddRemoveElementsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Element')]")
    WebElement clickAddElementButton;

    public AddRemoveElementsPage clickAddElementButton() {
        clickAddElementButton.click();
        return this;
    }

    public AddRemoveElementsPage checkIsElementDeletedPresent() {
        wait.until(ExpectedConditions.visibilityOf(deleteButton));
        return this;
    }
     @FindBy(xpath = "//button[contains(text(),'Delete')]")
        WebElement deleteButton;

    public AddRemoveElementsPage checkDeletionOfDeleteButton() {
        if (deleteButton.isDisplayed()) {
            // Якщо кнопка присутня, клік
            deleteButton.click();
            System.out.println("Кнопка Delete була присутня і була видалена.");
        } else {
            // Якщо кнопка відсутня
            System.out.println("Кнопка Delete відсутня, видалення не виконано.");
        }

        return this;
    }
}
//button[contains(text(),'Delete')]
//button[contains(text(),'Add Element')]