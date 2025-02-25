package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.List;

public class StatusCodePage extends BasePage {
    public StatusCodePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(css = "a")
    List<WebElement> allLinks;

    private int linkCounter = 0;//Переменная хранит счётчик ссылок

    public StatusCodePage checkAllURL() {
        System.out.println("🔗 Общее количество ссылок на странице: [" + allLinks.size() + "]");
        for (WebElement link : allLinks){
            linkCounter ++;
            String urlText = link.getText().trim();// Хранит текст ссылки
            String href = link.getAttribute("href");// Хранит ссылку
            System.out.println("🔗 Link " + linkCounter + ": [" + (!urlText.isEmpty() ? urlText :
                    (href != null && !href.isEmpty() ? href : "null")) + "], URL: [" + (href != null ? href : "null") + "]");
        }
        return this;
    }

    public StatusCodePage checkBrokenLinks() throws MalformedURLException {
        System.out.println("🔍 Общее количество ссылок на странице: [" + allLinks.size() + "]");
        for (WebElement link : allLinks) {
            String urlText = link.getText().trim();// Хранит текст ссылки
            String linkURL = link.getAttribute("href"); // Хранит саму ссылку
            verifyLink(linkURL, urlText);
        }
        assertAll();
        return this;
    }

}
