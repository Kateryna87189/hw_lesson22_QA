package herokuapp.internet_tests;

import herokuapp.core.TestBase;
import herokuapp.internet_tests.utils.RetryAnalyser;
import herokuapp.pages.DisappearingElementsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static herokuapp.pages.HomePage.HOME_PAGE_URL;

public class DisapperingElementsTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        app.driver.get(HOME_PAGE_URL + "/disappearing_elements");
    }
//
//    @Test(retryAnalyzer = RetryAnalyser.class)
//    public void disappearingElementsTestsPositiveTest() {
//        new DisappearingElementsPage(app.driver, app.wait)
//                .checkDisappearingElement("Gallery");
//    }
    @Test
    public void CheckStyleButtonPositiveTest(){
        String button = "Home";
        new DisappearingElementsPage(app.driver, app.wait)
                .checkStyleButton( button,"#DA4B4B", "18px", "#ececec")
                .hoverMouseOnButton(button)
                .checkStyleButton(button, "#000000", "20px", "#f2f2f2")
        ;
    }
}
