package herokuapp.internet_tests;

import herokuapp.core.TestBase;
import herokuapp.pages.CheckBoxPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static herokuapp.pages.HomePage.HOME_PAGE_URL;

public class CheckBoxTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        app.driver.get(HOME_PAGE_URL + "/checkboxes");
    }
    @Test
    public void printCheckBoxPositiveTest(){
        new CheckBoxPage(app.driver, app.wait)
                .printCheckBox()
        ;
    }

@Test
    public void selectCheckBoxByTextPositiveTest(){
        String checkBoxName = "checkbox 1";
        new CheckBoxPage(app.driver, app.wait)
                .selectCheckBoxByText(checkBoxName)
                .verifyCheckBox(checkBoxName)
                ;
    }
    @Test
    public void selectCheckBoxByTextWhithActionsPositiveTest(){
        String checkBoxName = "checkbox 1";
        new CheckBoxPage(app.driver, app.wait)
                .selectCheckBoxByTextWithActions(checkBoxName)//klick s pomow`u actin`s
                .verifyCheckBox(checkBoxName)
        ;
    }

    @Test
    public void selectCheckBoxByTextWhithRobotPositiveTest(){
        String checkBoxName = "checkbox 1";
        new CheckBoxPage(app.driver, app.wait)
                .selectCheckBoxByTextWithRobot(checkBoxName)//klick s pomow`u actin`s
                .verifyCheckBox(checkBoxName)
        ;
    }
}
//CheckBox text:  checkbox 1
//CheckBox text:  checkbox 2