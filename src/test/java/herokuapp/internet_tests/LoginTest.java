package herokuapp.internet_tests;

import herokuapp.core.TestBase;
import herokuapp.pages.HomePage;
import herokuapp.pages.LoginPage;
import herokuapp.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static herokuapp.pages.HomePage.HOME_PAGE_URL;

public class LoginTest extends TestBase {


    @BeforeMethod
    public void preCondition(){

        app.driver.get(HOME_PAGE_URL + "/login");
    }
    @Test
    public void loginPositiveTest(){
      new LoginPage(app.driver, app.wait)
               .enterPersonalData("tomsmith","SuperSecretPassword!")
               .selectLogin();
      Assert.assertEquals(app.driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
    }

    @Test
    @Parameters({"userName", "superPassword"})
    public void loginParameterPositiveTest(String userName, String superPassword){
        new LoginPage(app.driver, app.wait)
                .enterPersonalData(userName,superPassword)
                .selectLogin();
        Assert.assertEquals(app.driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
    }

    @Test
    public void loginNegativeTest(){
        new LoginPage(app.driver, app.wait)
                .enterPersonalData("tomsmith","")
                .selectLogin();

        Assert.assertEquals(app.driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
    }
    @Test(dataProvider = "loginDataProvider", dataProviderClass = DataProviders.class)
    public void loginDataProviderNegativeTest(String username, String password){
        new LoginPage(app.driver, app.wait)
                .enterPersonalData(username,password)
                .selectLogin();

        Assert.assertEquals(app.driver.getCurrentUrl(),"https://the-internet.herokuapp.com/login");
    }
}


