package com.demowebshop.fw;

import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isErrorMessagePresent() {
        return isElementPresent(By.xpath("//li[text()='The specified email already exists']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.name("FirstName"), user.getFirstName());
        type(By.name("LastName"), user.getLastName());
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
        type(By.name("ConfirmPassword"), user.getConfirmPassword());
    }

    public void clickOnRegistrationLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public boolean isContinueButtonPresent() {
        return isElementPresent(By.cssSelector(".button-1.register-continue-button"));
    }

    public boolean isLogOutButtonPresent() {
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".button-1.login-button"));
    }

    public void fillLoginForm(User user) {
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnRegistrationButton() {
        click(By.name("register-button"));
    }

    public boolean isRegisterLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/register']"));
    }

    public void clickOnLogOutButton() {
        click(By.cssSelector("a[href='/logout']"));
    }

    public boolean isLogInLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }

    public boolean isLogInErrorMessagePresent() {
        return isElementPresent(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));
    }

    public boolean isRegistrationFirstNameErrorMessagePresent() {
        return isElementPresent(By.xpath("//span[text()='First name is required.']"));
    }


    public boolean isRegistrationLastNameErrorMessagePresent() {
        return isElementPresent(By.xpath("//span[text()='Last name is required.']"));
    }


    public boolean isRegistrationEmailErrorMessagePresent() {
        return isElementPresent(By.xpath("//span[text()='Email is required.']"));
    }

    public boolean isRegistrationPasswordErrorMessagePresent() {
        return isElementPresent(By.xpath("//span[text()='Password is required.']"));
    }

    public boolean isRegistrationConfirmPasswordErrorMessagePresent() {
        return isElementPresent(By.xpath("//span[text()='Password is required.']"));
    }
}
