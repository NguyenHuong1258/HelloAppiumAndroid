package com.utilities.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.*;

public class ExtentReporterNG implements IReporter {
    static ExtentReports extentReports;
    static String reportFolder = "ExtentReport";

    public static ExtentReports extentReportGenerator() {
        String path = reportFolder + "/" + "index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Test report on Android");
        reporter.config().setDocumentTitle("Test report on Android");
        reporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Testing extent report", "Lea Ho");
        return extentReports;
    }
}
