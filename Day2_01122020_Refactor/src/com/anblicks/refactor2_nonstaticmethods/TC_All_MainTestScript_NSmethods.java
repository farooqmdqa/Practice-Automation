
// 2. Execute all the test cases by creating seperate single class and main method to call non-static methods by creating object of class name.

// Goal : Main method should not have any line of code except method call.

package com.anblicks.refactor2_nonstaticmethods;

//Execute all the test cases by calling non-static methods by creating object of class name.

public class TC_All_MainTestScript_NSmethods {

	public static void main(String[] args) throws Exception {

		// Test Case 1: Log-in with valid user name and password
		
		TC1_Login_Validcredentials_NSmethods tc1 = new TC1_Login_Validcredentials_NSmethods();
		
		tc1.openBrowser();
		
		tc1.launchApplication();
		
		tc1.validCredentials();
		
		tc1.validateLogin();
		
		tc1.closeBrowser();
		
		
		// Test Case 2: Log-in with incorrect username and incorrect password
		
		TC2_Login_Invalidcredentials_NSmethods tc2 = new TC2_Login_Invalidcredentials_NSmethods();
		
		tc2.openBrowser();
		
		tc2.launchApplication();
		
		tc2.invalidCredentials();
		
		tc2.validateLogin();
		
		tc2.closeBrowser();
		
						
		// Test Case 3: Log-in with correct username and empty password
		
		TC3_Login_Invalidcredentials_NSmethods tc3 = new TC3_Login_Invalidcredentials_NSmethods();
		
		tc3.openBrowser();
		
		tc3.launchApplication();
		
		tc3.invalidCredentials();
		
		tc3.validateLogin();
		
		tc3.closeBrowser();
		
		
		// Test Case 4: Log-in with empty username and correct password
		
		TC4_Login_Invalidcredentials_NSmethods tc4 = new TC4_Login_Invalidcredentials_NSmethods();
		
		tc4.openBrowser();
		
		tc4.launchApplication();
		
		tc4.invalidCredentials();
		
		tc4.validateLogin();
		
		tc4.closeBrowser();
		

		// Test Case 5: Log-in with empty username and empty password
		
		TC5_Login_Invalidcredentials_NSmethods tc5 = new TC5_Login_Invalidcredentials_NSmethods();
		
		tc5.openBrowser();
		
		tc5.launchApplication();
		
		tc5.invalidCredentials();
		
		tc5.validateLogin();
		
		tc5.closeBrowser();

		
		// Test Case 6: Login with valid case sensitive user name and password 
		
		TC6_Login_HandleCasesensitive_NSmethods tc6 = new TC6_Login_HandleCasesensitive_NSmethods();
		
		tc6.openBrowser();
		
		tc6.launchApplication();
		
		tc6.invalidCredentials();
		
		tc6.validateLogin();
		
		tc6.closeBrowser();
		
		
		// Test Case 7: Login with valid user name and password, Sign Out and navigate back to verify users login or not.
		
		TC7_Login_Authentication_NSmethods tc7 = new TC7_Login_Authentication_NSmethods();
		
		tc7.openBrowser();
		
		tc7.launchApplication();
		
		tc7.handleAuthentication();
		
		tc7.validateLogin();
		
		tc7.closeBrowser();
		
	}

}
