package computer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class executionDriver {
	
	// test data is provided from json file
	@DataProvider(name = "Test Case Bed")
	public Object [][] passData() throws FileNotFoundException, IOException, ParseException{
		return jsonReader.getJsondata(System.getProperty("user.dir") +"\\testCaseFile.json","Test Case Bed",13);
	}
	
	
	@Test(dataProvider = "Test Case Bed")
	public void crudOperationOnChrome(String testCaseName, String testScenarioMethod, String searchComputerName,
			String computerSearchAction, String computerName, String introducedDate, String  discontinuedDate,
			String  companyName, String  computerEditPageAction, String validationPoint, String validation,
			String element, String defaultValue) throws FileNotFoundException, IOException{
		
		// declaring variables 
		WebDriver driver = null;
		objectRepository objRepo = new objectRepository();		
		commonValidation objValidation = new commonValidation();
		performOperation objperformOperation = new performOperation();
		Properties prop = new Properties();
		
		// loading property to get url detail
		prop.load(new FileInputStream(System.getProperty("user.dir") +"\\config.Properties"));
		String applicationURL = prop.getProperty("applicationURL");
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
				
		String [] arrTestScenarioMethod =  testScenarioMethod.split(",");
		
		// Scenario are modularized into methods and called based upon sequence provided in test data
		for ( String operation : arrTestScenarioMethod ){
			switch(operation){
				case "R_URL":
					objperformOperation.r_URL(driver, applicationURL);
					break;
				case "COMPUTERSEARCH":
					objperformOperation.computerSearchPage(driver, objRepo, objValidation, searchComputerName, computerSearchAction, validationPoint, validation, element, defaultValue);
					break;	
				case "COMPUTERDETAIL":
					objperformOperation.computerEditPage(driver, objRepo, objValidation, computerName, introducedDate, discontinuedDate, companyName, computerEditPageAction, validationPoint, validation, element, defaultValue);
					break;
			}	
		}
		driver.close();
		
	}
	
	@Test(dataProvider = "Test Case Bed")
	public void crudOperationOnFireFox(String testCaseName, String testScenarioMethod, String searchComputerName,
			String computerSearchAction, String computerName, String introducedDate, String  discontinuedDate,
			String  companyName, String  computerEditPageAction, String validationPoint, String validation,
			String element, String defaultValue) throws FileNotFoundException, IOException{
		
		WebDriver driver = null;
		objectRepository objRepo = new objectRepository();		
		commonValidation objValidation = new commonValidation();
		performOperation objperformOperation = new performOperation();
		Properties prop = new Properties();
		
		prop.load(new FileInputStream(System.getProperty("user.dir") +"\\config.Properties"));
		String applicationURL = prop.getProperty("applicationURL");
		
		System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir") +"\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	
		String [] arrTestScenarioMethod =  testScenarioMethod.split(",");
		for ( String operation : arrTestScenarioMethod ){
			switch(operation){
				case "R_URL":
					objperformOperation.r_URL(driver, applicationURL);
					break;
				case "COMPUTERSEARCH":
					objperformOperation.computerSearchPage(driver, objRepo, objValidation, searchComputerName, computerSearchAction, validationPoint, validation, element, defaultValue);
					break;	
				case "COMPUTERDETAIL":
					objperformOperation.computerEditPage(driver, objRepo, objValidation, computerName, introducedDate, discontinuedDate, companyName, computerEditPageAction, validationPoint, validation, element, defaultValue);
					break;
			}	
		}
		driver.close();
		
	}
	@AfterClass
	public void report(){
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertAll();
	}
}
