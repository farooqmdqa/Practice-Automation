
// 2. Execute all the test cases by creating seperate single class and main method to call static methods by class name.

package com.testng2_staticmethods;

import org.testng.annotations.Test;

// Execute all the test cases by calling static methods by class name.

public class TestNG_TC_All_MainTestScript_SMethods {

	// Test Case 1: Log-in with valid user name and password.
	@Test(priority=1)
	public void testCase1() {
		
		TC1_Login_Validcredentials_SMethods.openBrowserandlaunchApplication();
		
		TC1_Login_Validcredentials_SMethods.validCredentials();
		
		TC1_Login_Validcredentials_SMethods.validateLogin();
		
		TC1_Login_Validcredentials_SMethods.closeBrowser();
		
		
	}

	// Test Case 2: Log-in with incorrect username and incorrect password.
	@Test(priority=2)
	public void testCase2() {
		
		TC2_Login_Invalidcredentials_SMethods.openBrowserandlaunchApplication();
		
		TC2_Login_Invalidcredentials_SMethods.invalidCredentials();
		
		TC2_Login_Invalidcredentials_SMethods.validateLogin();
		
		TC2_Login_Invalidcredentials_SMethods.closeBrowser();
		
	}
			
	//Test Case 3: Log-in with correct username and empty password.
	@Test(priority=3)
	public void testCase3() {
		
		TC3_Login_Invalidcredentials_SMethods.openBrowserandlaunchApplication();
		
		TC3_Login_Invalidcredentials_SMethods.invalidCredentials();
		
		TC3_Login_Invalidcredentials_SMethods.validateLogin();
		
		TC3_Login_Invalidcredentials_SMethods.closeBrowser();
		
	}
			
	// Test Case 4: Log-in with empty username and correct password.
	@Test(priority=4)
	public void testCase4() {
		
		TC4_Login_Invalidcredentials_SMethods.openBrowserandlaunchApplication();
		
		TC4_Login_Invalidcredentials_SMethods.invalidCredentials();
		
		TC4_Login_Invalidcredentials_SMethods.validateLogin();
		
		TC4_Login_Invalidcredentials_SMethods.closeBrowser();
		
	}	


	// Test Case 5: Log-in with empty username and empty password.
		
	@Test(priority=5)
	public void testCase5() {
		
		TC5_Login_Invalidcredentials_SMethods.openBrowserandlaunchApplication();
		
		TC5_Login_Invalidcredentials_SMethods.invalidCredentials();
		
		TC5_Login_Invalidcredentials_SMethods.validateLogin();
		
		TC5_Login_Invalidcredentials_SMethods.closeBrowser();
		
	}	

		
	// Test Case 6: Login with valid case sensitive username and password. 
	@Test(priority=6)
	public void testCase6() {
		
		TC6_Login_HandleCasesensitive_SMethods.openBrowserandlaunchApplication();
		
		TC6_Login_HandleCasesensitive_SMethods.invalidCredentials();
		
		TC6_Login_HandleCasesensitive_SMethods.validateLogin();
		
		TC6_Login_HandleCasesensitive_SMethods.closeBrowser();
		
	}		
			
	// Test Case 7: Login with valid username and password, Sign Out, Navigate back to verify user is in login page or not.
	@Test(priority=7)
	public void testCase7() throws Exception {
		
		TC7_Login_Authentication_SMethods.openBrowserandlaunchApplication();
		
		TC7_Login_Authentication_SMethods.handleAuthentication();
		
		TC7_Login_Authentication_SMethods.validateLogin();
		
		TC7_Login_Authentication_SMethods.closeBrowser();
		
	}	
		
}
