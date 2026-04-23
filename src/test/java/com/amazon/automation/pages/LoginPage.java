package com.amazon.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Locators — seedha login page ke
    By emailField    = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginButton   = By.cssSelector("button[type='submit']");
    By errorMessage  = By.cssSelector(".alert-danger");
    By accountHeading = By.cssSelector("#content h2");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Seedha login page open karo
    public void goToLoginPage() {
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        System.out.println("Login page opened");
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void login(String email, String password) {
        goToLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public boolean isLoginSuccessful() {
        try {
            return driver.getCurrentUrl().contains("account/account");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorDisplayed() {
        try {
            return driver.findElement(errorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}