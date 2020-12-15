
//  Execute all the test cases by creating single class and testng annotations.

package com.anblicks.testng4_parameterization;

import org.testng.annotations.Test;

public class TestNG_TC_All_Login_MainTestScript_SM {
	
	
	// Test Case 1: Log-in with valid user name and password.
	@Test(priority=1)	
	public void testCase1() {
		
		TC_All_Login_Smethods_Parameterization.openBrowserandlaunchApplication("http://practice.automationtesting.in/");

		TC_All_Login_Smethods_Parameterization.inputCredentials("testuser001", "1Drefnam1!");

		TC_All_Login_Smethods_Parameterization.validateLogin1("testuser001");

		TC_All_Login_Smethods_Parameterization.closeBrowser();
	}	


	
	// Test Case 2: Log-in with incorrect username and incorrect password.
	@Test(priority=2)	
	public void testCase2() {

		TC_All_Login_Smethods_Parameterization.openBrowserandlaunchApplication("http://practice.automationtesting.in/");

		TC_All_Login_Smethods_Parameterization.inputCredentials("testuser123", "1Drefnam");

		TC_All_Login_Smethods_Parameterization.validateLogin2("Invalid Username.");

		TC_All_Login_Smethods_Parameterization.closeBrowser();
	}	

	
	// Test Case 3: Log-in with correct username and empty password.
	@Test(priority=3)	
	public void testCase3() {

		TC_All_Login_Smethods_Parameterization.openBrowserandlaunchApplication("http://practice.automationtesting.in/");

		TC_All_Login_Smethods_Parameterization.inputCredentials("testuser001", "");

		TC_All_Login_Smethods_Parameterization.validateLogin2("Password is required.");

		TC_All_Login_Smethods_Parameterization.closeBrowser();
	}	
	

	// Test Case 4: Log-in with empty username and correct password.
	@Test(priority=4)	
	public void testCase4() {

		TC_All_Login_Smethods_Parameterization.openBrowserandlaunchApplication("http://practice.automationtesting.in/");

		TC_All_Login_Smethods_Parameterization.inputCredentials("", "1Drefnam1!");

		TC_All_Login_Smethods_Parameterization.validateLogin2("Username is required.");

		TC_All_Login_Smethods_Parameterization.closeBrowser();
	}		

	// Test Case 5: Log-in with empty username and empty password.
	@Test(priority=5)	
	public void testCase5() {

		TC_All_Login_Smethods_Parameterization.openBrowserandlaunchApplication("http://practice.automationtesting.in/");

		TC_All_Login_Smethods_Parameterization.inputCredentials("", "");

		TC_All_Login_Smethods_Parameterization.validateLogin2("Username is required.");

		TC_All_Login_Smethods_Parameterization.closeBrowser();
	}

	// Test Case 6: Login with valid case sensitive user name and password.
	@Test(priority=6)	
	public void testCase6() {

		TC_All_Login_Smethods_Parameterization.openBrowserandlaunchApplication("http://practice.automationtesting.in/");

		TC_All_Login_Smethods_Parameterization.inputCredentials("TESTUSER001", "1DREFNAM1!");

		TC_All_Login_Smethods_Parameterization.validateLogin2("TESTUSER001");

		TC_All_Login_Smethods_Parameterization.closeBrowser();
	}	

	
	// Test Case 7: Login with Authentication.
	@Test(priority=7)	
	public void testCase7() {

		TC_All_Login_Smethods_Parameterization.openBrowserandlaunchApplication("http://practice.automationtesting.in/");

		TC_All_Login_Smethods_Parameterization.inputCredentials("testuser001", "1Drefnam1!");

		TC_All_Login_Smethods_Parameterization.signOut();

		TC_All_Login_Smethods_Parameterization.validateLogin3("Login");

		TC_All_Login_Smethods_Parameterization.closeBrowser();

	}

}
