package ups.nj.listener;

import static org.junit.Assume.assumeNoException;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.HTMLReporter;

public class Reporting extends TestListenerAdapter{
	
	// below three are variable
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time start
		String repName = "report-"+ timeStamp + ".html";
		
		htmlReporter	= new ExtentHtmlReporter(System.getProperty("user,dir", "/ExtentReport/" + repName));
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") +"/extent-config.xml" );
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user","Alam");
		
		htmlReporter.config().setDocumentTitle("Automation Test Project");// Title of report
		htmlReporter.config().setReportName("Function Test Project");// Name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
		
		
}
	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	
	}
		
		public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName()); // create new entry in the report	
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));	
			
			//String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\" + tr.getName();
			
			//File f = new File(screenshotPath);
			//if (f.exists()) {
				
				
				//try {
					
			//		logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));	
			//	} catch (I0Exception e) {
			//			e.printStackTrace();
			//	}
				
			//}
			
			
		}
			
		public void onTestSkipped(ITestResult tr) {
			logger = extent.createTest(tr.getName()); // create new entry in the report
			logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
				
				
			}
		public void onFinish(ITestContext testContext) {
			extent.flush();
			
		}
	}