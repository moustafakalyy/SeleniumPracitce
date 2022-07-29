package com.automationpractice.pages;

import com.automationpractice.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends BasePage {

    private By inStockItemLabel = By.xpath("//span[text()=\"In stock\"]");

    public CartPage(WebDriver driver) throws Exception {
        super(driver);
        Utilities.isWebElementPresent(inStockItemLabel, driver);

    }

    public Boolean isChosenItemPresent(String itemName) throws Exception {
        By errorElement = By.xpath(" //td//p//a[text()='" + itemName + "']");
        return Utilities.isWebElementPresent(errorElement, driver);
    }
}