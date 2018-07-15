package computer;

public class objectRepository {
	
	// Declaring Object Names
	
	static private String txt_ComputerSearch;
	static private String txt_ComputerName;
	static private String txt_IntroducedDate;
	static private String txt_DiscontinuedDate;
	
	static private String lnk_ComputerName;
	static private String lnk_IntroducedDate;
	static private String lnk_DiscontinuedDate;
	static private String lnk_Company;
	
	static private String lst_Company;
	
	static private String btn_FilterByName;
	static private String btn_AddNewComputer;
	static private String btn_SaveComputer;
	static private String btn_DeleteComputer;
	static private String btn_Cancel;
		
	static private String lbl_ConfirmationMsg;
	static private String lbl_NothingToDisplay;
	
	// Constructor to initialize objects properties into variables
	public objectRepository() {
		
		// 	Text Elements 
		txt_ComputerSearch = "searchbox";	
		txt_ComputerName = "name";
		txt_IntroducedDate = "introduced";
		txt_DiscontinuedDate = "discontinued";

		//	Link Elements
		lnk_ComputerName = "#main > table > tbody > tr:nth-child(1) > td:nth-child(1) > a";
		lnk_IntroducedDate = "#main > table > tbody > tr > td:nth-child(2)";
		lnk_DiscontinuedDate = "#main > table > tbody > tr > td:nth-child(3)"	;	
		lnk_Company = "#main > table > tbody > tr > td:nth-child(4)";
		
		// List Elements
		lst_Company = "company";
		
		// Button Elements
		btn_FilterByName = "searchsubmit";				
		btn_AddNewComputer = "add";
		btn_SaveComputer = "#main > form:nth-child(2) > div > input";
		btn_DeleteComputer = "#main > form.topRight > input";
		btn_Cancel = "#main > form:nth-child(2) > div > a";
		
		// Label Elements
		lbl_ConfirmationMsg = "#main > div.alert-message.warning";
		lbl_NothingToDisplay = "#main > div.well > em";
	}
	
	// Method is created to fetch the object properties details
	public String getObjectValue(String element){
		switch(element){
			case "txt_ComputerSearch":
				return txt_ComputerSearch;
			case "txt_ComputerName":
				return txt_ComputerName;
			case "txt_IntroducedDate":
				return txt_IntroducedDate;
			case "txt_DiscontinuedDate":
				return txt_DiscontinuedDate;
			case "lnk_ComputerName":
				return lnk_ComputerName;
			case "lnk_IntroducedDate":
				return lnk_IntroducedDate;
			case "lnk_DiscontinuedDate":
				return lnk_DiscontinuedDate;
			case "lnk_Company":
				return lnk_Company;
			case "lst_Company":
				return lst_Company;			
			case "btn_FilterByName":
				return btn_FilterByName;
			case "btn_AddNewComputer":
				return btn_AddNewComputer;
			case "btn_SaveComputer":
				return btn_SaveComputer;
			case "btn_DeleteComputer":
				return btn_DeleteComputer;
			case "btn_Cancel":
				return btn_Cancel;
			case "lbl_ConfirmationMsg":
				return lbl_ConfirmationMsg;
			case "lbl_NothingToDisplay":
				return lbl_NothingToDisplay;
		}
		return null;		
	}
}
