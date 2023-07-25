package liseners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestLisener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("===Start "+result.getMethod().getMethodName()+"===");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("===== WIN ======");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("===== Falur :"+result.getMethod().getMethodName()+"=====");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
