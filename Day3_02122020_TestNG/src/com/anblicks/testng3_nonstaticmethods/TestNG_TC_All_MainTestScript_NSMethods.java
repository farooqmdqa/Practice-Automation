
//  Execute all the test cases by creating single class and testng annotations.

package com.anblicks.testng3_nonstaticmethods;

import org.testng.annotations.Test;

// Execute all the test cases by calling static methods by class name.

public class TestNG_TC_All_MainTestScript_NSMethods {

	// Test Case 1: Log-in with valid user name and password.
	@Test(priority=1)
	public void testCase1() {
		
		TC1_Login_Validcredentials_NSMethods tc1 = new TC1_Login_Validcredentials_NSMethods();
		
		tc1.openBrowserandlaunchApplication();
		
		tc1.validCredentials();
		
		tc1.validateLogin();
		
		tc1.closeBrowser();
		
		
	}

	// Test Case 2: Log-in with incorrect username and incorrect password.
	@Test(priority=2)
	public void testCase2() {
		
		
		TC2_Login_Invalidcredentials_NSMethods tc2 = new TC2_Login_Invalidcredentials_NSMethods();
		
		tc2.openBrowserandlaunchApplication();
		
		tc2.invalidCredentials();
		
		tc2.validateLogin();
		
		tc2.closeBrowser();
		
	}
			
	//Test Case 3: Log-in with correct username and empty password.
	@Test(priority=3)
	public void testCase3() {
		
		TC3_Login_Invalidcredentials_NSMethods tc3 = new TC3_Login_Invalidcredentials_NSMethods();
		
		tc3.openBrowserandlaunchApplication();
		
		tc3.invalidCredentials();
		
		tc3.validateLogin();
		
		tc3.closeBrowser();
		
	}
			
	// Test Case 4: Log-in with empty username and correct password.
	@Test(priority=4)
	public void testCase4() {
		
		TC4_Login_Invalidcredentials_NSMethods tc4 = new TC4_Login_Invalidcredentials_NSMethods();
		
		tc4.openBrowserandlaunchApplication();
		
		tc4.invalidCredentials();
		
		tc4.validateLogin();
		
		tc4.closeBrowser();
		
	}	


	// Test Case 5: Log-in with empty username and empty password.
		
	@Test(priority=5)
	public void testCase5() {
		
		TC5_Login_Invalidcredentials_NSMethods tc5 = new TC5_Login_Invalidcredentials_NSMethods();
		
		tc5.openBrowserandlaunchApplication();
		
		tc5.invalidCredentials();
		
		tc5.validateLogin();
		
		tc5.closeBrowser();
		
	}	

		
	// Test Case 6: Login with valid case sensitive username and password. 
	@Test(priority=6)
	public void testCase6() {
		
		TC6_Login_HandleCasesensitive_NSMethods tc6 = new TC6_Login_HandleCasesensitive_NSMethods();
		
		tc6.openBrowserandlaunchApplication();
		
		tc6.invalidCredentials();
		
		tc6.validateLogin();
		
		tc6.closeBrowser();
		
	}		
			
	// Test Case 7: Login with valid username and password, Sign Out, Navigate back to verify user is in login page or not.
	@Test(priority=7)
	public void testCase7() throws Exception {
		
		TC7_Login_Authentication_NSMethods tc7 = new TC7_Login_Authentication_NSMethods();
		
		tc7.openBrowserandlaunchApplication();
		
		tc7.handleAuthentication();
		
		tc7.validateLogin();
		
		tc7.closeBrowser();
		
	}	
		
}
