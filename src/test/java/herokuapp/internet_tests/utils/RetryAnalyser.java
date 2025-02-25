package herokuapp.internet_tests.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 8;

    @Override//metod dlya retestinga
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("Retrying test ["+result.getName() + "] within ["+ retryCount +"] times");
            return true;
        }
        return false;
    }
}
