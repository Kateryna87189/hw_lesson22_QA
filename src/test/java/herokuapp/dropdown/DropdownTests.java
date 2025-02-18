package herokuapp.dropdown;

import herokuapp.core.TestBase;
import herokuapp.pages.DropdownPage;
import herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTests extends TestBase {
    @BeforeMethod
    public void preCondition(){
        new HomePage(app.driver,app.wait).getDropdownPage().hideAds();
    }


    @Test
    public void dropdownListPositiveTest() {
       // String option = "Option 1";

        new DropdownPage(app.driver, app.wait)
                .printAllOptions()
                .selectAndVerifyAllOptions()
        ;
    }

    @Test
    public void dropdownListNegativeTest() {
        new DropdownPage(app.driver, app.wait)
                .selectNegativeExistentOption("Неіснуюча опція"); // Спроба вибрати неіснуючу опцію
    }
}
