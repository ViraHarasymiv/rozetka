package com.softserve.rozetka.tests;

import com.softserve.rozetka.locators.BrandsPageElements;
import com.softserve.rozetka.locators.HomePageElements;
import com.softserve.rozetka.locators.NotebooksAndComputersPageElements;
import com.softserve.rozetka.locators.NotebooksPageElements;
import com.softserve.rozetka.pages.HomePage;
import com.softserve.rozetka.pages.NotebooksPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class NoteBookFilteringTest extends BaseRunner {
    private static final String BRAND = "Dell";

    @BeforeClass
    public void setPreconditions() {
        setDriver();
        new HomePage(driver)
                .closeBunner()
                .clickOnCatalogButton()
                .clickOnNotebooksAndComputersCategory()
                .closeBunner()
                .clickOnNotebooksCategory()
                .closeBunner();
    }

    @Test(priority = 1)
    public void checkSearchingNotebooksOfOneBrand() {
        List<WebElement> results = new NotebooksPage(driver)
                .enterBrand()
                .clickOnBrandsCheckBox()
                .getItems();
        Assert.assertTrue(results
                .stream()
                .allMatch(webelement -> webelement.getText().contains(BRAND)));
    }

    @Test(priority = 2)
    public void checkSearchingNotebooksOfInvalidBrand() {
        List<WebElement> allCheckBoxes = new NotebooksPage(driver)
                .enterInvalidBrand()
                .getBrandCheckBoxes();
        Assert.assertTrue(allCheckBoxes.isEmpty());
    }

    @AfterClass
    public void closeWindow(){
       afterSuite();
    }
}
