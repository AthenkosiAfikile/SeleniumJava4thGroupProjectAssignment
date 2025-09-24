package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{

    private static ExtentReports extent;
    private static ExtentTest extentTest;
    private WebDriver driver;

    @Override
    public void onTestStart(ITestResult result){
        extentTest=extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        extentTest.log(Status.FAIL,"Test Case "+result.getMethod().getMethodName()+" has Failed");
    }

    @Override
    public void onTestSuccess(ITestResult result){
        extentTest.log(Status.PASS,"Test Case "+result.getMethod().getMethodName()+" has Passed");
    }

    @Override
    public void onTestSkipped(ITestResult result){
        extentTest.log(Status.SKIP,"Test Case "+result.getMethod().getMethodName()+" has been Skipped");
    }

    @Override
    public void onFinish(ITestContext results){
        extent.flush();
    }

    public void onStart(ITestContext results){
        extent=ExtentReportManager.extentReportSetup();
    }

}
