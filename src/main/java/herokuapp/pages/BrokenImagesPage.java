package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

public class BrokenImagesPage extends BasePage {
    public BrokenImagesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

//    @FindBy(css = "img")
//    List<WebElement> allImages;
List<WebElement> allImages = driver.findElements(By.tagName("img"));
    public BrokenImagesPage checkAllBrokenLinksImages() throws IOException {
        System.out.println("All found <img> on the page: [" + allImages.size() + "]");
//        for (WebElement image : allImages) {
//            String imageURL = image.getAttribute("src");
//            String imageALT = image.getAttribute("alt");
//            if (imageURL != null) {
//                verifyLink(imageALT,imageURL);
//            }
//        }
//        assertAll();
//        return this;
        for (WebElement image : allImages) {
            String imageURL = image.getAttribute("src");
            URL url = new URL(imageURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode >= 400) {
                System.err.println("❌ Битое изображение: " + imageURL);
            } else {
                System.out.println("✅ Изображение загружается: " + imageURL);
            }
        }
        return this;
    }
    }



//for (WebElement image : allImages) {
//        String imageURL = image.getAttribute("src");
//        URL url = new URL(imageURL);
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("GET");
//        connection.connect();
//
//        int responseCode = connection.getResponseCode();
//        if (responseCode >= 400) {
//            System.err.println("❌ Битое изображение: " + imageURL);
//        } else {
//            System.out.println("✅ Изображение загружается: " + imageURL);
//        }
//    }
//}


