package com.amazon.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchPage {

    WebDriver driver;

    // Locators
    By searchBox     = By.name("search");
    By searchButton  = By.cssSelector("button.btn-default");
    By searchResults = By.cssSelector(".product-thumb");
    By firstProduct  = By.cssSelector(".product-thumb h4 a");

    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void searchProduct(String productName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
        System.out.println("Searched for: " + productName);
    }

    public void clickFirstProduct() {
        driver.findElement(firstProduct).click();
        System.out.println("Clicked first product");
    }

    // Verifications
    public boolean areResultsDisplayed() {
        try {
            List<WebElement> results = driver.findElements(searchResults);
            System.out.println("Results found: " + results.size());
            return results.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public int getResultsCount() {
        try {
            return driver.findElements(searchResults).size();
        } catch (Exception e) {
            return 0;
        }
    }
}