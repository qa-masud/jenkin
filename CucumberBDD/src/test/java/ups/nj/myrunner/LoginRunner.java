package ups.nj.myrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(  
		
		plugin= {"pretty","json:target/cucumber-reports/cucumber.json"},
		features = "CucumberBDD/Background.feature",
		glue = "ups.nj.stefdef",
		//strict=false,  // 
		  monochrome=true, //  readable
		  dryRun=false      // with out browser execute
		)
public class LoginRunner extends AbstractTestNGCucumberTests {

}
