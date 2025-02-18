package herokuapp.multiple_windows;

import herokuapp.core.TestBase;
import herokuapp.pages.HomePage;
import herokuapp.pages.MultiplePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowsTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        new HomePage(app.driver,app.wait).getMultipleWindows().hideAds();
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