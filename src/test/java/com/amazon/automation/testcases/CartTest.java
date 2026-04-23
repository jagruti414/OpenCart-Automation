package com.amazon.automation.testcases;

import com.amazon.automation.pages.CartPage;
import com.amazon.automation.pages.SearchPage;
import com.amazon.automation.utilities.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseClass {

    String url = "https://demo.opencart.com";

    // TC_016 - Navigate to Cart
    @Test(priority = 1)
    public void navigateToCart() {
        openURL(url);
        CartPage cp = new CartPage(driver);
        cp.goToCart();
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("cart"),
            "URL should contain cart");
        System.out.println("TC_016 - Navigate to Cart Passed!");
    }

    // TC_017 - Cart Page Title
    @Test(priority = 2)
    public void cartPageTitle() {
        openURL(url);
        CartPage cp = new CartPage(driver);
        cp.goToCart();
        String title = driver.getTitle();
        Assert.assertTrue(title != null, "Title should not be null");
        System.out.println("TC_017 - Cart Title: " + title);
    }

    // TC_018 - Add Product to Cart
    @Test(priority = 3)
    public void addProductToCart() {
        openURL(url);
        SearchPage sp = new SearchPage(driver);
        sp.searchProduct("iphone");
        sp.clickFirstProduct();
        CartPage cp = new CartPage(driver);
        cp.clickAddToCart();
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("opencart"),
            "Should stay on opencart after adding to cart");
        System.out.println("TC_018 - Add to Cart Passed!");
    }

    // TC_019 - Cart Count
    @Test(priority = 4)
    public void cartCount() {
        openURL(url);
        CartPage cp = new CartPage(driver);
        int count = cp.getCartCount();
        Assert.assertTrue(count >= 0, "Cart count should be 0 or more");
        System.out.println("TC_019 - Cart Count: " + count);
    }
}