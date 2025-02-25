package herokuapp.internet_tests;

import herokuapp.core.TestBase;
import herokuapp.pages.FramesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static herokuapp.pages.HomePage.HOME_PAGE_URL;

public class FramesTests extends TestBase {
    @BeforeMethod
    public void preCondition(){
    //    new HomePage(app.driver,app.wait).getNestedFrames().hideAds();
        app.driver.get(HOME_PAGE_URL + "/nested_frames");
    }


    @Test
    public void iframePositiveTest() {
        new FramesPage(app.driver, app.wait)
                .getListOfFrames();
    }

    @Test
    public void switchToIframeByIndexPositiveTest() {
        new FramesPage(app.driver, app.wait)
                .switchToIframeByIndex(1)
                .verifyIframeText("BOTTOM")
        ;
    }


    @Test
    public void switchToLeftIframeByNamePositiveTest() {
        new FramesPage(app.driver, app.wait)
                .switchToIframeByName("frame-top")
                .switchToIframeByName("frame-left")
                .verifyIframeText("LEFT")
                .stepUp()
                .switchToIframeByName("frame-middle")
                .verifyIframeText("MIDDLE")
                .stepUp()
                .switchToIframeByName("frame-right")
                .verifyIframeText("RIGHT")
                .exitFromAllFrames()
                .switchToIframeByName("frame-bottom")
                .verifyIframeText("BOTTOM")
        ;
    }

}
