package com.demowebshop.tests;

import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    private WebDriver driver;


    @BeforeMethod
    public void precondition() {
        driver =app.getDriver();
            if (!app.getUser().isLogInLinkPresent()) {
                app.getUser().clickOnLogOutButton();
            }

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail("maynard000@gmail.com").setPassword("Maynard@gmail1234"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void isItemAddedToCardTest() {
        app.getItemAddToCart().clickOnAddToCartButton();
        app.getItemAddToCart().pause(1000);
        app.getItemAddToCart().clickOnShoppingCartLink();
        WebElement itemInCart = driver.findElement(By.xpath("//a[@class='product-name' and text()='14.1-inch Laptop']"));
        String item = itemInCart.getText();
        Assert.assertEquals(itemInCart.getText(), "14.1-inch Laptop");

    }

    @AfterMethod
    public void postCondition() {
        app.getItemAddToCart().clickOnRemoveFromCartCheckbox();
        app.getItemAddToCart().clickOnUpdateShoppingCartButton();
    }

}
