import java.io.UnsupportedEncodingException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;

import driver.DriverFactory;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;	

@RunWith(Cucumber.class)				
@CucumberOptions(features="src/test/resources/features", plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})	
	
public class Runner {
		
	public static ExtentReports extentReports;
	
	@BeforeClass
	public static void start() {
		
		System.out.println("[LOG] Iniciando testes...");
		
		extentReports = new ExtentReports();
		try {
			extentReports.setGherkinDialect("pt");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		System.out.println("Iniciando driver...");
		DriverFactory.startDriver();		
	}
	
	@AfterClass
	public static void tearDown() {
		System.out.println("Fechando driver...");
		DriverFactory.closeDriver();
		extentReports.flush();
	}
	
}
