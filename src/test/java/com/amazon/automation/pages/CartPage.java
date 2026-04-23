package com.amazon.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage {

    WebDriver driver;

    // Locators
    By addToCartButton = By.id("button-cart");
    By cartIcon        = By.cssSelector("button.btn-inverse");
    By cartItems       = By.cssSelector("#cart ul li");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
        System.out.println("Clicked Add to Cart");
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
        System.out.println("Opened Cart");
    }

    // Verifications
    public int getCartCount() {
        try {
            List<WebElement> items = driver.findElements(cartItems);
            return items.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean isProductAddedToCart() {
        return getCartCount() > 0;
    }
}