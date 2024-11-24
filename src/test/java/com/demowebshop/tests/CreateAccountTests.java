package com.demowebshop.tests;


import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isRegisterLinkPresent()) {
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test
    public void registrationNewUserPositiveTest(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User()
                .setFirstName("Maynard")
                .setLastName("Keenan")
                .setEmail("maynard0000" + i + "@gmail.com")
                .setPassword("Maynard@gmail1234").setConfirmPassword( "Maynard@gmail1234"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isContinueButtonPresent());

    }

    @Test
    public void registrationExistedUserNegativeTest(){
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User()
                .setFirstName("Maynard")
                .setLastName("Keenan")
                .setEmail("maynard00@gmail.com")
                .setPassword("Maynard@gmail1234").setConfirmPassword( "Maynard@gmail1234"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isErrorMessagePresent());

    }


}