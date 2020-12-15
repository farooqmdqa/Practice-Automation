
// 2. Execute all the test cases by creating seperate single class and main method to call non-static methods by creating object of class name.
// Give the input parameters i.e. username, password in the main method by parameteriztion in static methods
// That means we need to give declare data type in the arguements in the static methods.

// Goal : Main method should not have any line of code except method call.

package com.refactor3_parameterization;

public class TC_All_Login_Maintestscript_Staticmethods {

	public static void main(String[] args) throws Exception {

		// Test Case 1: Log-in with valid user name and password.
		
		TC_All_Login_Staticmethods.openBrowser();
		
		TC_All_Login_Staticmethods.launchApplication("http://practice.automationtesting.in/");
		
		TC_All_Login_Staticmethods.inputCredentials("testuser001", "1Drefnam1!");
		
		TC_All_Login_Staticmethods.validateLogin1("testuser001");
		
		TC_All_Login_Staticmethods.closeBrowser();
		
		
		// Test Case 2: Log-in with incorrect username and incorrect password.
		
		TC_All_Login_Staticmethods.openBrowser();
		
		TC_All_Login_Staticmethods.launchApplication("http://practice.automationtesting.in/");
		
		TC_All_Login_Staticmethods.inputCredentials("testuser123", "1Drefnam");
		
		TC_All_Login_Staticmethods.validateLogin2("Invalid Username.");
		
		TC_All_Login_Staticmethods.closeBrowser();
		
						
		// Test Case 3: Log-in with correct username and empty password.
		
		TC_All_Login_Staticmethods.openBrowser();
		
		TC_All_Login_Staticmethods.launchApplication("http://practice.automationtesting.in/");
		
		TC_All_Login_Staticmethods.inputCredentials("testuser001", "");
		
		TC_All_Login_Staticmethods.validateLogin2("Password is required.");
		
		TC_All_Login_Staticmethods.closeBrowser();
		
		
		// Test Case 4: Log-in with empty username and correct password.
		
		TC_All_Login_Staticmethods.openBrowser();
		
		TC_All_Login_Staticmethods.launchApplication("http://practice.automationtesting.in/");
		
		TC_All_Login_Staticmethods.inputCredentials("", "1Drefnam1!");
		
		TC_All_Login_Staticmethods.validateLogin2("Username is required.");
		
		TC_All_Login_Staticmethods.closeBrowser();
		

		// Test Case 5: Log-in with empty username and empty password.
		
		TC_All_Login_Staticmethods.openBrowser();
		
		TC_All_Login_Staticmethods.launchApplication("http://practice.automationtesting.in/");
		
		TC_All_Login_Staticmethods.inputCredentials("", "");
		
		TC_All_Login_Staticmethods.validateLogin2("Username is required.");
		
		TC_All_Login_Staticmethods.closeBrowser();

		
		// Test Case 6: Login with valid case sensitive user name and password.
		
		TC_All_Login_Staticmethods.openBrowser();
		
		TC_All_Login_Staticmethods.launchApplication("http://practice.automationtesting.in/");
		
		TC_All_Login_Staticmethods.inputCredentials("TESTUSER001", "1DREFNAM1!");
		
		TC_All_Login_Staticmethods.validateLogin2("TESTUSER001");
		
		TC_All_Login_Staticmethods.closeBrowser();
		
		
		// Test Case 7: Login with valid user name and password, Sign Out, Navigate back to verify if users is in login page or not.
		
		TC_All_Login_Staticmethods.openBrowser();
		
		TC_All_Login_Staticmethods.launchApplication("http://practice.automationtesting.in/");
		
		TC_All_Login_Staticmethods.inputCredentials("testuser001", "1Drefnam1!");
		
		TC_All_Login_Staticmethods.validateLogin3("Login");
		
		TC_All_Login_Staticmethods.closeBrowser();
		
	}

}
