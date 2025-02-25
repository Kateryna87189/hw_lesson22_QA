package herokuapp.internet_tests;

import herokuapp.core.TestBase;
import herokuapp.pages.Dropdown1Page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static herokuapp.pages.HomePage.HOME_PAGE_URL;

//!v klase napisan
public class DropDownTest extends TestBase {
    @BeforeMethod
    public void preCondition() {
            app.driver.get(HOME_PAGE_URL + "/dropdown");
    }

    @Test
    public void selectDropdownOptionByNamePositiveTest(){
        String option = "Option 1";
        new Dropdown1Page(app.driver, app.wait)
                .selectOptionByText(option)
                .verifySelectedOption(option)
        ;
    }
    @Test
    public void selectDropdownOptionByValuePositiveTest(){
        String option =  "2";
        new Dropdown1Page(app.driver, app.wait)
                .selectOptionByValue(option)
                .verifySelectedOption(option)
        ;
    }
    @Test
    public void selectDropdownOptionByIndexPositiveTest(){
        int index =  1;
        String option = "Option "+ index;
        new Dropdown1Page(app.driver, app.wait)
                .selectOptionByIndex(index)
                .verifySelectedOption(option)
        ;
    }
    @Test
    public void selectDropdownOptionByIndexDefaultPositiveTest(){
        new Dropdown1Page(app.driver, app.wait)
              //  .selectOptionByIndex(0)
                .verifySelectedOption("Please select an option")
        ;
    }
}
