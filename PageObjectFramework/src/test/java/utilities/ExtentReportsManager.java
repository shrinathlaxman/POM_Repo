package utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsManager {

	
	public static ExtentReports getReportObj() {
		
		File filePath=new File(System.getProperty("user.dir")+"\\reports\\result.html");
		ExtentSparkReporter reporter=new ExtentSparkReporter(filePath);
		reporter.config().setDocumentTitle("Automation Result");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setReportName("Test Result");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Shrinath");
		extent.setSystemInfo("Selenium", "4.20.0");
		extent.setSystemInfo("TestNG", "6.11");
		
		return extent;
		
	}
}
