package com.automationpractice.pages;

import com.automationpractice.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BlousesPage extends BasePage {

    private By blouseProductImage = By.xpath("//*[@class=\"product_img_link\"]");
    private By blouseProductName = By.xpath("//*[@itemprop=\"name\"]");
    private By addToCartButton = By.xpath("//span[text()='Add to cart']");
    private By proceedToCheckOutButton = By.xpath("//*[@class=\"btn btn-default button button-medium\"]");
    public static String popupImage = "//img[@class='layer_cart_img img-responsive']";
    public static String trashbutton = "//i[@class='icon-trash']";


    public BlousesPage(WebDriver driver) throws Exception {
        super(driver);
        Utilities.isWebElementPresent(blouseProductImage, driver);
    }

    public CartPage addItemToCartAndProceedToCheckOut() throws Exception {
        Utilities.waitAndHoverOverElement(blouseProductImage, driver);
        Utilities.waitAndClickOnWebElement(addToCartButton, driver);
        Utilities.waitAndClickOnWebElement(proceedToCheckOutButton, driver);
        return new CartPage(this.driver);
    }

    public String getItemName() throws Exception {
        return Utilities.waitAndGetWebElementText(blouseProductName, driver);

    }
}
