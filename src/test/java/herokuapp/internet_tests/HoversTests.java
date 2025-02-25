package herokuapp.internet_tests;

import herokuapp.core.TestBase;
import herokuapp.pages.HoversPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static herokuapp.pages.HomePage.HOME_PAGE_URL;


public class HoversTests extends TestBase {
    private HoversPage hoversPage;

    @BeforeMethod
    public void preCondition() {
        app.driver.get(HOME_PAGE_URL + "/hovers");
        hoversPage = new HoversPage(app.driver, app.wait);
    }

    @Test
    public void testHoverOverUser1() {
        hoversPage
                .hoverOverUser(hoversPage.user1) // Наводимо курсор на першого користувача
                .checkUserInfoIsDisplayed(hoversPage.user1Info) // Перевіряємо, що додаткова інформація з'явилася
                .checkUserInfoText(hoversPage.user1Info, "name: user1"); // Перевіряємо текст додаткової інформації
    }

    @Test
    public void testHoverOverUser2() {
        hoversPage
                .hoverOverUser(hoversPage.user2)
                .checkUserInfoIsDisplayed(hoversPage.user2Info)
                .checkUserInfoText(hoversPage.user2Info, "name: user2");
    }

    @Test
    public void testHoverOverUser3() {
        hoversPage
                .hoverOverUser(hoversPage.user3)
                .checkUserInfoIsDisplayed(hoversPage.user3Info)
                .checkUserInfoText(hoversPage.user3Info, "name: user3");
    }
}






