package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReportManager {

    private static final String reportDir = System.getProperty("user.dir") + "/Reports"+"/Ndosi Test Automation Report";

    public static ExtentReports extentReports;
    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentReports extentReportSetup(){

        extentReports= new ExtentReports();
        extentSparkReporter= new ExtentSparkReporter(new File(reportDir));
        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setDocumentTitle("Extent Report");
        extentSparkReporter.config().setReportName("Inventory");

        extentReports.setSystemInfo("OS",System.getProperty("os.name"));
        extentReports.setSystemInfo("Execution Machine",System.getProperty("user.name"));
        extentReports.setSystemInfo("Java Version",System.getProperty("java.version"));
        extentReports.setSystemInfo(" "," ");
        extentReports.setSystemInfo("Tester Name", "Athenkosi Afikile (Mentor: Mr. AA)");
        extentReports.setSystemInfo("Testing Site", "Ndosi Test Automation");

        return extentReports;
    }


}
