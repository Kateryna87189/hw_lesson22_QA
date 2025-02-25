package herokuapp.internet_tests;

import herokuapp.core.TestBase;
import herokuapp.pages.FileUploaderPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static herokuapp.pages.HomePage.HOME_PAGE_URL;

public class FileUploaderTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        app.driver.get(HOME_PAGE_URL + "/upload");}

    @Test
    public void fileUploaderPositiveTest(){
new FileUploaderPage(app.driver, app.wait)
        .chooseFileByChooseFileButton("C:\\Users\\Kateryna Nuzhna\\Downloads\\Image20250221114857.png")
       .clickOnUploadButton()
       .verifyFileName("Image20250221114857.png")
        ;
    }
    @Test
    public void fileUploaderInBoxPositiveTest(){
        new FileUploaderPage(app.driver, app.wait)
                .chooseFileInBox("C:\\Users\\Kateryna Nuzhna\\Downloads\\Image20250221114857.png")
                .verifyFileNameInBox("Image20250221114857.png")
        ;
    }


}
