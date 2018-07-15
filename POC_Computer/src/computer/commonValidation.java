package computer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class commonValidation {

	SoftAssert softAssert = new SoftAssert();
	
	public void guiValidation(WebDriver driver, String validationPosition, String validationPoint, String validation,
			String element, String defaultValue){
		
		// Variable declaration and assignment
		objectRepository objRepo = new objectRepository();
		String [] arrValidationPoint = validationPoint.split(",");
		String [] arrValidation = validation.split(",");
		String [] arrElement = element.split(",");
		String [] arrDefaultValue = defaultValue.split(",");
		int pos = 0 ; 
		
		
		for (String validationPos : arrValidationPoint) {
			if (validationPos.equals(validationPosition)) {
				arrElement[pos] = objRepo.getObjectValue(arrElement[pos]);
				switch(arrValidation[pos]){
					case "ISEXIST":
						fieldValidation(driver, arrElement[pos], arrDefaultValue[pos]);
						break;		
					case "DEFAULTVALUE":
						fieldValidation(driver, arrElement[pos], arrDefaultValue[pos]);
						break;	
				}
				pos ++;				
			}
		}
		
	} 
	public void fieldValidation(WebDriver driver, String validate, String expectedDefaultValue){
		try{
			if (driver.findElement(By.cssSelector(validate)).isDisplayed()) {
				String actual = driver.findElement(By.cssSelector(validate)).getText().trim();
				if (actual.equals(expectedDefaultValue)) {
					softAssert.assertTrue(true);
					Reporter.log("Validation of Element:  " + "<i><font color='Blue'>Actual:  " + actual + ",   Expected:  " + expectedDefaultValue + "</font></i>" + " - Validation Passed");
				}
				else{
					Reporter.log("Validation of Element:  " + "<i><font color='Red'>Actual:  " + actual + ",   Expected:  " + expectedDefaultValue + "-  Validation Failed"  + "</font></i>");
					Assert.assertTrue(false);
				}
			}			
		}	
		catch(Exception e)
		{
			Reporter.log("Validation of Element:  " + "<i><font color='Red'>Actual Element Not Found  " + ",   Expected:  " + expectedDefaultValue + "-  Validation Failed"  + "</font></i>");
			Assert.assertTrue(false);
		}	
	}	
}
