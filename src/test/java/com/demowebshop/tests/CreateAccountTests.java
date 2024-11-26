package com.demowebshop.tests;


import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import com.demowebshop.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isRegisterLinkPresent()) {
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test
    public void registrationNewUserPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User()
                .setFirstName(UserData.FIRSTNAME)
                .setLastName(UserData.LASTNAME)
                .setEmail("maynard0000" + i + "@gmail.com")
                .setPassword(UserData.PASSWORD).setConfirmPassword(UserData.CONFIRMPASSWORD));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isContinueButtonPresent());

    }


    @Test(dataProvider ="addNewUser", dataProviderClass= DataProviders.class)
    public void registerNewUserPositiveFromDataProviderTest(String firstName, String lastName,String email, String password, String confirmPassword) {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password).setConfirmPassword(confirmPassword));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isContinueButtonPresent());

    }




    @Test(dataProvider ="addNewUserWithCsv", dataProviderClass= DataProviders.class)
    public void registerNewUserPositiveFromDataProviderWithCsvFileTest(User user) {
//        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isContinueButtonPresent());

    }

    @Test
    public void registrationExistedUserNegativeTest() {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User()
                .setFirstName(UserData.FIRSTNAME)
                .setLastName(UserData.LASTNAME)
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD).setConfirmPassword(UserData.CONFIRMPASSWORD));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isErrorMessagePresent());

    }

    @Test
    public void registrationWithoutFirstNameNegativeTest() {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User()
                .setFirstName("")
                .setLastName(UserData.LASTNAME)
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD).setConfirmPassword(UserData.CONFIRMPASSWORD));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isRegistrationFirstNameErrorMessagePresent());

    }

    @Test
    public void registrationWithoutLastNameNegativeTest() {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User()
                .setFirstName(UserData.FIRSTNAME)
                .setLastName("")
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD).setConfirmPassword(UserData.CONFIRMPASSWORD));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isRegistrationLastNameErrorMessagePresent());

    }


    @Test
    public void registrationWithoutEmailNegativeTest() {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User()
                .setFirstName(UserData.FIRSTNAME)
                .setLastName(UserData.LASTNAME)
                .setEmail("")
                .setPassword(UserData.PASSWORD).setConfirmPassword(UserData.CONFIRMPASSWORD));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isRegistrationEmailErrorMessagePresent());

    }

    @Test
    public void registrationWithoutPasswordNegativeTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User()
                .setFirstName(UserData.FIRSTNAME)
                .setLastName(UserData.LASTNAME)
                .setEmail(UserData.EMAIL)
                .setPassword("")
                .setConfirmPassword(UserData.CONFIRMPASSWORD));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isRegistrationPasswordErrorMessagePresent());
    }

    @Test
    public void registrationWithoutConfirmPasswordNegativeTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User()
                .setFirstName(UserData.FIRSTNAME)
                .setLastName(UserData.LASTNAME)
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD)
                .setConfirmPassword(""));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isRegistrationConfirmPasswordErrorMessagePresent());

    }
}