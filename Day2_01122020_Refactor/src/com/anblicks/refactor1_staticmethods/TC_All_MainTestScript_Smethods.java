
// 2. Execute all the test cases by creating seperate single class and main method to call static methods by class name.
// Goal : Main method should not have any line of code except method call.

package com.anblicks.refactor1_staticmethods;

// Execute all the test cases by calling static methods by class name.

public class TC_All_MainTestScript_Smethods {

	public static void main(String[] args) throws Exception {

		// Test Case 1: Log-in with valid user name and password.
		
		TC1_Login_Validcredentials_Smethods.openBrowser();
		
		TC1_Login_Validcredentials_Smethods.launchApplication();
		
		TC1_Login_Validcredentials_Smethods.validCredentials();
		
		TC1_Login_Validcredentials_Smethods.validateLogin();
		
		TC1_Login_Validcredentials_Smethods.closeBrowser();
		
		
		// Test Case 2: Log-in with incorrect username and incorrect password.
		
		TC2_Login_Invalidcredentials_Smethods.openBrowser();
		
		TC2_Login_Invalidcredentials_Smethods.launchApplication();
		
		TC2_Login_Invalidcredentials_Smethods.invalidCredentials();
		
		TC2_Login_Invalidcredentials_Smethods.validateLogin();
		
		TC2_Login_Invalidcredentials_Smethods.closeBrowser();
		
						
		// Test Case 3: Log-in with correct username and empty password.
		
		TC3_Login_Invalidcredentials_Smethods.openBrowser();
		
		TC3_Login_Invalidcredentials_Smethods.launchApplication();
		
		TC3_Login_Invalidcredentials_Smethods.invalidCredentials();
		
		TC3_Login_Invalidcredentials_Smethods.validateLogin();
		
		TC3_Login_Invalidcredentials_Smethods.closeBrowser();
		
		
		// Test Case 4: Log-in with empty username and correct password.
		
		TC4_Login_Invalidcredentials_Smethods.openBrowser();
		
		TC4_Login_Invalidcredentials_Smethods.launchApplication();
		
		TC4_Login_Invalidcredentials_Smethods.invalidCredentials();
		
		TC4_Login_Invalidcredentials_Smethods.validateLogin();
		
		TC4_Login_Invalidcredentials_Smethods.closeBrowser();
		

		// Test Case 5: Log-in with empty username and empty password.
		
		TC5_Login_Invalidcredentials_Smethods.openBrowser();
		
		TC5_Login_Invalidcredentials_Smethods.launchApplication();
		
		TC5_Login_Invalidcredentials_Smethods.invalidCredentials();
		
		TC5_Login_Invalidcredentials_Smethods.validateLogin();
		
		TC5_Login_Invalidcredentials_Smethods.closeBrowser();

		
		// Test Case 6: Login with valid case sensitive username and password. 
		
		TC6_Login_HandleCasesensitive_Smethods.openBrowser();
		
		TC6_Login_HandleCasesensitive_Smethods.launchApplication();
		
		TC6_Login_HandleCasesensitive_Smethods.invalidCredentials();
		
		TC6_Login_HandleCasesensitive_Smethods.validateLogin();
		
		TC6_Login_HandleCasesensitive_Smethods.closeBrowser();
		
		
		// Test Case 7: Login with valid username and password, Sign Out, Navigate back to verify user is in login page or not.
		
		TC7_Login_Authentication_Smethods.openBrowser();
		
		TC7_Login_Authentication_Smethods.launchApplication();
		
		TC7_Login_Authentication_Smethods.handleAuthentication();
		
		TC7_Login_Authentication_Smethods.validateLogin();
		
		TC7_Login_Authentication_Smethods.closeBrowser();
		
	}

}
