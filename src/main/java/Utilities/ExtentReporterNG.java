package Utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
     public static ExtentReports getReportObject() {
    	String path = System.getProperty("user.dir")+"//Resources//index.html";
    	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
    	reporter.config().setDocumentTitle("Framework Report");
    	reporter.config().setReportName("Regression Results");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Shreedevi");
        return extent;
     }
}
