package com.demowebshop.tests;


import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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