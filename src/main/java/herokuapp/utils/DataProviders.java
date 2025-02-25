package herokuapp.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {"tomsmith",""},
                {"tomsmith2","Password@1"},
                {"tomsmith1","SuperSecretPassword!"}
        };

    }

//    @DataProvider
//    public Object[][] framesNamePositiveProvider() {
//        return new Object[][]{
//                {"frame-top", "frame-left", "LEFT"},
//                {"frame-top", "frame-middle", "MIDDLE"},
//                {"frame-top", "frame-right", "RIGHT"},
//                {"*", "frame-bottom", "BOTTOM"}
//
//        };
//    }
}
