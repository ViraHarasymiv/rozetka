package com.softserve.rozetka.pages.computers_and_notebooks_page;

import com.softserve.rozetka.locators.computers_and_notebooks_page_locators.MenuSectionLocators;
import com.softserve.rozetka.pages.BasePageWithHeader;
import com.softserve.rozetka.pages.notebooks_page.NotebooksPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComputersAndNotebooksPage extends BasePageWithHeader{
    private MenuSection menuSection;

    private static final String URL = "https://rozetka.com.ua/ua/computers-notebooks/c80253/";

    public ComputersAndNotebooksPage(WebDriver driver) {
        super(driver);
        menuSection = new MenuSection(driver);
   }
   public ComputersAndNotebooksPage openPage(){
        driver.navigate().to(URL);
        return this;
   }

    public MenuSection getMenuSection() {
        return menuSection;
    }
}