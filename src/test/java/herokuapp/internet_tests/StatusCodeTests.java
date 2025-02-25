package herokuapp.internet_tests;

import herokuapp.core.TestBase;
import herokuapp.pages.StatusCodePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static herokuapp.pages.HomePage.HOME_PAGE_URL;

public class StatusCodeTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        app.driver.get(HOME_PAGE_URL + "/status_codes");
    }
// 🔗
    @Test
    public void statusCodePositiveTest() throws MalformedURLException {
        new StatusCodePage(app.driver, app.wait)
                .checkAllURL()
                .checkBrokenLinks()
                ;
    }
}
