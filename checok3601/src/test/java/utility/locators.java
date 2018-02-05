package utility;

import org.openqa.selenium.By;

public class locators {
	public static String dropdown = "ddlAct";
	//*************login page********************
	public static String Uname = "ctl00_ContentPlaceHolder1_txtUserName";
	public static String pass = "ctl00_ContentPlaceHolder1_txtPassword";
	public static String button = "ctl00_ContentPlaceHolder1_btnLogin";
	public static String changepass = "ctl00_hlnkPasswordChange";
	
//******************case reg**************
	public static String regcase = "btnNewCase_Click";
	public static String clientdropdown = "ctl00_ContentPlaceHolder1_ddlClient_Input";
	public static String clientName =".//*[text()='wibro chennai']";
			public static String projectdropdown ="ctl00_ContentPlaceHolder1_ddlProject_Input";
			
			public static String projectName =".//*[text()='patient management system']";
			public static String cFName = "ctl00_ContentPlaceHolder1_txtFirstName";
			public static String cLName = "ctl00_ContentPlaceHolder1_txtLastName";
			public static String candidateID = "ctl00_ContentPlaceHolder1_txtClientCandidateID";
			public static String add = "ctl00_ContentPlaceHolder1_btnAddComponent_input";
			
//**********************Data Entry Supervispor******************
			public static String search = "txtCaserefNo";
			public static String btn="btnsearch" ;
			public static String tbodycheck= "//*[@id='grdTaskList']//tbody//td//span";
			public static String priority = "//*[@id='grdTaskList']//tbody//td[10]/select";
			public static String alert = "html/body/div[3]/div/div/table/tbody/tr[3]/td/button[1]";
			public static String assignuser = "//*[@id='grdTaskList']//tbody//td[11]/select";
			
			
//*******************Data Entry Stage****************
			public static String getnext = "btnGetNext";
			
}
