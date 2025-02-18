package herokuapp.nested_frames;

import herokuapp.core.TestBase;
import herokuapp.pages.FramesPage;
import herokuapp.pages.HomePage;
import herokuapp.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTests extends TestBase {


    @BeforeMethod
    public void preCondition(){
        new HomePage(app.driver,app.wait).getNestedFrames().hideAds();
    }

    @Test (dataProvider = "framesNamePositiveProvider", dataProviderClass = DataProviders.class)
    public void framesNamePositiveProviderTest(String parentFrameName, String childFrameName, String frameText) {
        new FramesPage(app.driver, app.wait)
                .switchToFrameByFrameName(parentFrameName, childFrameName)
               // .verifyIFrameText(frameText)
        ;
    }


    @Test
    public void framePositiveTest(){
       new FramesPage(app.driver, app.wait)
               .getListOfFrames();
    }



}
