
//  Execute all the test cases by creating single class and testng annotations.

package com.anblicks.testng4_parameterization;

import org.testng.annotations.Test;

import com.anblicks.testng4_parameterization.TC_All_Login_NSmethods_Parameterization;

public class TestNG_TC_All_Login_MainTestScript_NSM {

	// Test Case 1: Log-in with valid user name and password.

	@Test(priority=1)	
	public void testCase1() {

		TC_All_Login_NSmethods_Parameterization tc = new TC_All_Login_NSmethods_Parameterization();

		tc.openBrowserandlaunchApplication("http://practice.automationtesting.in/");

		tc.inputCredentials("testuser001", "1Drefnam1!");

		tc.validateLogin1("testuser001");

		tc.closeBrowser();
	}	


	// Test Case 2: Log-in with incorrect username and incorrect password.

	@Test(priority=2)	
	public void testCase2() {

		TC_All_Login_NSmethods_Parameterization tc = new TC_All_Login_NSmethods_Parameterization();

		tc.openBrowserandlaunchApplication("http://practice.automationtesting.in/");

		tc.inputCredentials("testuser123", "1Drefnam");

		tc.validateLogin2("Invalid Username.");

		tc.closeBrowser();
	}	

	// Test Case 3: Log-in with correct username and empty password.

	@Test(priority=3)	
	public void testCase3() {

		TC_All_Login_NSmethods_Parameterization tc = new TC_All_Login_NSmethods_Parameterization();

		tc.openBrowserandlaunchApplication("http://practice.automationtesting.in/");

		tc.inputCredentials("testuser001", "");

		tc.validateLogin2("Password is required.");

		tc.closeBrowser();
	}		

	// Test Case 4: Log-in with empty username and correct password.

	@Test(priority=4)	
	public void testCase4() {

		TC_All_Login_NSmethods_Parameterization tc = new TC_All_Login_NSmethods_Parameterization();
		
		tc.openBrowserandlaunchApplication("http://practice.automationtesting.in/");

		tc.inputCredentials("", "1Drefnam1!");

		tc.validateLogin2("Username is required.");

		tc.closeBrowser();
	}		

	// Test Case 5: Log-in with empty username and empty password.

	@Test(priority=5)	
	public void testCase5() {

		TC_All_Login_NSmethods_Parameterization tc = new TC_All_Login_NSmethods_Parameterization();

		tc.openBrowserandlaunchApplication("http://practice.automationtesting.in/");

		tc.inputCredentials("", "");

		tc.validateLogin2("Username is required.");

		tc.closeBrowser();
	}

	// Test Case 6: Login with valid case sensitive user name and password.

	@Test(priority=6)	
	public void testCase6() {

		TC_All_Login_NSmethods_Parameterization tc = new TC_All_Login_NSmethods_Parameterization();

		tc.openBrowserandlaunchApplication("http://practice.automationtesting.in/");

		tc.inputCredentials("TESTUSER001", "1DREFNAM1!");

		tc.validateLogin2("TESTUSER001");

		tc.closeBrowser();
	}	

	// Test Case 7: Login with Authentication.

	@Test(priority=7)	
	public void testCase7() {

		TC_All_Login_NSmethods_Parameterization tc = new TC_All_Login_NSmethods_Parameterization();

		tc.openBrowserandlaunchApplication("http://practice.automationtesting.in/");

		tc.inputCredentials("testuser001", "1Drefnam1!");

		tc.signOut();

		tc.validateLogin3("Login");

		tc.closeBrowser();

	}

}
