package herokuapp.internet_tests;

import herokuapp.core.TestBase;
import herokuapp.pages.AddRemoveElementsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static herokuapp.pages.HomePage.HOME_PAGE_URL;

public class AddRemoveElementsTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        app.driver.get(HOME_PAGE_URL + "/add_remove_elements/");
    }
   @Test
    public void addRemoveAndDeleteElementsPositiveTest(){
    new AddRemoveElementsPage(app.driver, app.wait)
           .clickAddElementButton()
           .checkIsElementDeletedPresent()
           .checkDeletionOfDeleteButton()
           ;
    }
}
