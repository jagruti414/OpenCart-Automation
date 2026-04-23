package com.amazon.automation.testcases;

import com.amazon.automation.pages.LoginPage;
import com.amazon.automation.utilities.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    String url = "https://demo.opencart.com";

    // TC_001 - Valid Login
    @Test(priority = 1)
    public void validLogin() {
        openURL(url);
        LoginPage lp = new LoginPage(driver);
        lp.login("demo@demo.com", "demo");
        boolean isLoggedIn = lp.isLoginSuccessful();
        Assert.assertTrue(isLoggedIn, "Login should be successful");
        System.out.println("TC_001 - Valid Login Passed!");
    }

    // TC_002 - Invalid Password
    @Test(priority = 2)
    public void invalidPassword() {
        openURL(url);
        LoginPage lp = new LoginPage(driver);
        lp.login("demo@demo.com", "wrongpass");
        boolean error = lp.isErrorDisplayed();
        Assert.assertTrue(error, "Error should appear");
        System.out.println("TC_002 - Invalid Password Passed!");
    }

    // TC_003 - Invalid Email
    @Test(priority = 3)
    public void invalidEmail() {
        openURL(url);
        LoginPage lp = new LoginPage(driver);
        lp.login("wrong@wrong.com", "demo");
        boolean error = lp.isErrorDisplayed();
        Assert.assertTrue(error, "Error should appear");
        System.out.println("TC_003 - Invalid Email Passed!");
    }

    // TC_004 - Empty Email
    @Test(priority = 4)
    public void emptyEmail() {
        openURL(url);
        LoginPage lp = new LoginPage(driver);
        lp.login("", "demo");
        boolean error = lp.isErrorDisplayed();
        Assert.assertTrue(error, "Error should appear");
        System.out.println("TC_004 - Empty Email Passed!");
    }
}