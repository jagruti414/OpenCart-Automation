package com.amazon.automation.testcases;

import com.amazon.automation.pages.SearchPage;
import com.amazon.automation.utilities.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseClass {

    String url = "https://demo.opencart.com";

    // TC_008 - Valid Search
    @Test(priority = 1)
    public void validSearch() {
        openURL(url);
        SearchPage sp = new SearchPage(driver);
        sp.searchProduct("iphone");
        boolean results = sp.areResultsDisplayed();
        Assert.assertTrue(results, "Results should be displayed");
        System.out.println("TC_008 - Valid Search Passed!");
    }

    // TC_009 - Search Results Count
    @Test(priority = 2)
    public void searchResultsCount() {
        openURL(url);
        SearchPage sp = new SearchPage(driver);
        sp.searchProduct("mac");
        int count = sp.getResultsCount();
        Assert.assertTrue(count > 0, "Count should be greater than 0");
        System.out.println("TC_009 - Results Count: " + count);
    }

    // TC_010 - Empty Search
    @Test(priority = 3)
    public void emptySearch() {
        openURL(url);
        SearchPage sp = new SearchPage(driver);
        sp.searchProduct("");
        boolean pageLoaded = driver.getCurrentUrl().contains("opencart");
        Assert.assertTrue(pageLoaded, "Page should stay on OpenCart");
        System.out.println("TC_010 - Empty Search Passed!");
    }

    // TC_011 - Invalid Search
    @Test(priority = 4)
    public void invalidSearch() {
        openURL(url);
        SearchPage sp = new SearchPage(driver);
        sp.searchProduct("xyzabc123");
        boolean pageLoaded = driver.getTitle() != null;
        Assert.assertTrue(pageLoaded, "Page should load without crash");
        System.out.println("TC_011 - Invalid Search Passed!");
    }
}