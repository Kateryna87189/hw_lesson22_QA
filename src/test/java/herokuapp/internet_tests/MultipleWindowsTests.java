package herokuapp.internet_tests;

import herokuapp.core.TestBase;
import herokuapp.pages.MultiplePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static herokuapp.pages.HomePage.HOME_PAGE_URL;

public class MultipleWindowsTests extends TestBase {

    @BeforeMethod
    public void preCondition(){

        app.driver.get(HOME_PAGE_URL + "/windows");
    }

    @Test
    public void multipleWindowsPositiveTest(){
        new MultiplePage(app.driver, app.wait)
                .getClickOnLinkHereClick()
                 .verifyText("New Window")

        ;
    }

}
//a[contains(text(),'Click Here')]
//h3[contains(text(),'New Window')]