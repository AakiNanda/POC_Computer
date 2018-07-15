package computer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class performOperation {
	
	// Launch application URL
	public void r_URL(WebDriver driver, String applicationURL) {
		driver.get(applicationURL);
		driver.manage().window().maximize();
	}

	// Perform operation on first page of the application 
	public void computerSearchPage(WebDriver driver , objectRepository objRepo, commonValidation objValidation ,String computerName, String computerSearchAction,
			String validationPoint, String validation, String element, String defaultValue) {
		
		if (! (computerName.isEmpty())) {
			driver.findElement(By.id(objRepo.getObjectValue("txt_ComputerSearch"))).sendKeys(computerName);		
			driver.findElement(By.id(objRepo.getObjectValue("btn_FilterByName"))).click();
		}
		
		objValidation.guiValidation(driver,"POST_COMPUTER_SEARCH",validationPoint, validation, element, defaultValue);
		
		switch(computerSearchAction){
			case "ADDCOMPUTER":
				driver.findElement(By.id(objRepo.getObjectValue("btn_AddNewComputer"))).click();
				break;
			case "EDITCOMPUTER":
				driver.findElement(By.cssSelector(objRepo.getObjectValue("lnk_ComputerName"))).click();
				break;
		}		
	}
	
	// Perform operation on 2nd page of the application 
	public void computerEditPage(WebDriver driver, objectRepository objRepo, commonValidation objValidation ,String newComputerName, String introducedDate,
			String discontinuedDate, String companyName, String computerEditPageAction, String validationPoint, String validation,
			String element, String defaultValue) {
		
		if (! (newComputerName.isEmpty())) {
			driver.findElement(By.id(objRepo.getObjectValue("txt_ComputerName"))).clear();
			driver.findElement(By.id(objRepo.getObjectValue("txt_ComputerName"))).sendKeys(newComputerName);
		}
		
		if (! (introducedDate.isEmpty())) {
			driver.findElement(By.id(objRepo.getObjectValue("txt_IntroducedDate"))).clear();
			driver.findElement(By.id(objRepo.getObjectValue("txt_IntroducedDate"))).sendKeys(introducedDate);
		}
		
		if (! (discontinuedDate.isEmpty())) {
			driver.findElement(By.id(objRepo.getObjectValue("txt_DiscontinuedDate"))).clear();
			driver.findElement(By.id(objRepo.getObjectValue("txt_DiscontinuedDate"))).sendKeys(discontinuedDate);
		}
		
		if (! (companyName.isEmpty())) {
		Select dropdown = new Select(driver.findElement(By.id(objRepo.getObjectValue("lst_Company"))));
		dropdown.selectByVisibleText(companyName);
		}
		
		switch(computerEditPageAction){
			case "CANCEL":
				driver.findElement(By.cssSelector(objRepo.getObjectValue("btn_Cancel"))).click();
				break;
			case "SAVE":
				driver.findElement(By.cssSelector(objRepo.getObjectValue("btn_SaveComputer"))).click();
				break;
			case "DELETE":
				driver.findElement(By.cssSelector(objRepo.getObjectValue("btn_DeleteComputer"))).click();
				break;
		}
				
		objValidation.guiValidation(driver,"POST_COMPUTER_EDIT_PAGE_ACTION",validationPoint, validation, element, defaultValue);
	}
}
