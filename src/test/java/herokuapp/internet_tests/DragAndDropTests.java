package herokuapp.internet_tests;

import herokuapp.core.TestBase;
import herokuapp.pages.DragAndDropPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static herokuapp.pages.HomePage.HOME_PAGE_URL;

public class DragAndDropTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        app.driver.get(HOME_PAGE_URL + "/drag_and_drop");
    }

    @Test
    public void dragAndDropPositiveTest() {
        new DragAndDropPage(app.driver, app.wait)
                .actionDragMe()
                .verifyText("a")
                ;
    }
}
