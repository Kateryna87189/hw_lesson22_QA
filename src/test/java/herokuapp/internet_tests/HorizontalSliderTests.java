package herokuapp.internet_tests;

import herokuapp.core.TestBase;
import herokuapp.pages.HorizontalSliderPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static herokuapp.pages.HomePage.HOME_PAGE_URL;

public class HorizontalSliderTests extends TestBase {
    private HorizontalSliderPage sliderPage;

    @BeforeMethod
    public void preCondition() {
        app.driver.get(HOME_PAGE_URL + "/horizontal_slider");
    }

    //!нові методи написані в класі
    @Test
    public void horisontalSliderPositiveTest() {
        Float setSlider = 4.5F;
        new HorizontalSliderPage(app.driver, app.wait)
                .moveSlider(setSlider)
                .verifySliderValue(setSlider)
        ;
    }

}