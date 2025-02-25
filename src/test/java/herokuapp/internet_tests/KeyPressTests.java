package herokuapp.internet_tests;

import herokuapp.core.TestBase;
import herokuapp.pages.KeyPressPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static herokuapp.pages.HomePage.HOME_PAGE_URL;

public class KeyPressTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        app.driver.get(HOME_PAGE_URL + "/key_presses");
    }

    @Test
    public void keyPressPositiveTest(){
        String letter = "a";
        new KeyPressPage(app.driver, app.wait)
                .pressKey(letter)
                .verifyPressKey(letter)
        ;
    }
}
