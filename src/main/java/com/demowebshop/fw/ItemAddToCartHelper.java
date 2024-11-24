package com.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemAddToCartHelper extends BaseHelper{
    public ItemAddToCartHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnShoppingCartLink() {
        click(By.cssSelector("a[href='/cart']"));
    }

    public void clickOnAddToCartButton() {
        click(By.cssSelector("input[onclick*='/addproducttocart/catalog/31/']"));
    }

    public void clickOnUpdateShoppingCartButton() {
        click(By.cssSelector("input.button-2.update-cart-button"));
    }

    public void clickOnRemoveFromCartCheckbox() {
        WebElement checkbox = driver.findElement(By.cssSelector("input[name='removefromcart']"));
        checkbox.click();
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }
}
