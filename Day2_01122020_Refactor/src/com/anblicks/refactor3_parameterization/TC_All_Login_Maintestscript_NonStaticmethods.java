
// Execute all the test cases by creating seperate single class and main method to call non-static methods by creating object of class name.
// Give the input parameters i.e. username, password in the main method by parameteriztion in non-static methods
// That means we need to give declare data type in the arguements in the non-static methods.

// Goal : Main method should not have any line of code except method call.

package com.anblicks.refactor3_parameterization;

public class TC_All_Login_Maintestscript_NonStaticmethods {
	

	public static void main(String[] args) throws Exception {
		
		// Test Case 1: Log-in with valid user name and password.
		
		TC_All_Login_NonStaticmethods tc = new TC_All_Login_NonStaticmethods();
		
		tc.openBrowser();
		
		tc.launchApplication("http://practice.automationtesting.in/");
		
		tc.inputCredentials("testuser001", "1Drefnam1!");
		
		tc.validateLogin1("testuser001");
		
		tc.closeBrowser();
		
		
	 // Test Case 2: Log-in with incorrect username and incorrect password.
		
		tc.openBrowser();
		
		tc.launchApplication("http://practice.automationtesting.in/");
			    
		tc.inputCredentials("testuser123", "1Drefnam");
		
		tc.validateLogin2("Invalid Username.");
		
		tc.closeBrowser();
		
		
	// Test Case 3: Log-in with correct username and empty password.
		
		tc.openBrowser();
		
		tc.launchApplication("http://practice.automationtesting.in/");
				
		tc.inputCredentials("testuser001", "");
		
		tc.validateLogin2("Password is required.");
		
		tc.closeBrowser();
		
		
	// Test Case 4: Log-in with empty username and correct password.
		
		tc.openBrowser();
		
		tc.launchApplication("http://practice.automationtesting.in/");
		
		tc.inputCredentials("", "1Drefnam1!");
		
		tc.validateLogin2("Username is required.");
		
		tc.closeBrowser();
		
		
	// Test Case 5: Log-in with empty username and empty password.
		
		tc.openBrowser();
		
		tc.launchApplication("http://practice.automationtesting.in/");
		
		tc.inputCredentials("", "");
		
		tc.validateLogin2("Username is required.");
		
		tc.closeBrowser();

		
	// Test Case 6: Login with valid case sensitive user name and password.
		
		tc.openBrowser();
		
		tc.launchApplication("http://practice.automationtesting.in/");
		
		tc.inputCredentials("TESTUSER001", "1DREFNAM1!");
		
		tc.validateLogin2("TESTUSER001");
		
		tc.closeBrowser();
		
		
		// Test Case 7: Login with valid user name and password, Sign Out, Navigate back to verify if users is in login page or not.
		
		tc.openBrowser();
		
		tc.launchApplication("http://practice.automationtesting.in/");
		
		tc.inputCredentials("testuser001", "1Drefnam1!");
		
		tc.signOut();
		
		tc.validateLogin3("Login");
		
		tc.closeBrowser();
		
	}

}
