package herokuapp.internet_tests;

import herokuapp.core.TestBase;
import herokuapp.pages.DropdownPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static herokuapp.pages.HomePage.HOME_PAGE_URL;

public class DropdownTests extends TestBase {
    @BeforeMethod
    public void preCondition(){

        app.driver.get(HOME_PAGE_URL + "/dropdown");
    }


    @Test
    public void dropdownListPositiveTest() {
        String option = "Option 1";
        String optionList = "Option 2";

        new DropdownPage(app.driver, app.wait)
                .printAllOptions(option)
                  .printAllOptions(optionList)
        ;
    }

    @Test
    public void dropdownListNegativeTest() {
        new DropdownPage(app.driver, app.wait)
                .selectNegativeExistentOption("Неіснуюча опція");
    }
}
