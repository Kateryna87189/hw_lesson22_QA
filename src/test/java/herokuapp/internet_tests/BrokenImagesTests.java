package herokuapp.internet_tests;

import herokuapp.core.TestBase;
import herokuapp.pages.BrokenImagesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static herokuapp.pages.HomePage.HOME_PAGE_URL;

public class BrokenImagesTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        app.driver.get(HOME_PAGE_URL + "/broken_images");}

    @Test
    public void brokenImagesPositiveTest() throws IOException {
        new BrokenImagesPage(app.driver,app.wait)
                .checkAllBrokenLinksImages();
    }
}
