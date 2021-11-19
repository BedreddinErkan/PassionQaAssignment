package com.project.stepdefs;

import com.project.pages.BuildAppPage;
import com.project.pages.DashboardPage;
import com.project.pages.CheckOutPage;
import com.project.pages.SignUpPage;
import com.project.utilties.ConfigurationReader;
import com.project.utilties.Driver;
import com.project.utilties.ScreenShot;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class stepdef {

    public static WebDriver oDriver;

    @Before
    public void beforeMethod(Scenario scenario) {
        System.out.println("Screenshot file created");
        ScreenShot.scenario=scenario;
        ScreenShot.createFolder();
    }

    @When("^User choose App Category \"([^\"]*)\"$")
    public void userChooseAppCategory(String category) throws Throwable {
        BuildAppPage buildAppPage = new BuildAppPage();
        Assert.assertTrue(buildAppPage.select_AppCategoty(category));
    }

    @Then("^Verify user see theme Related App Category \"([^\"]*)\"$")
    public void verifyUserSeeThemeRelatedAppCategory(String category) throws Throwable {
        BuildAppPage buildAppPage = new BuildAppPage();
        Assert.assertTrue(buildAppPage.Verify_AppCategory(category));
    }

    @Given("^User on the \"([^\"]*)\" Page$")
    public void userOnThePage(String page) throws Throwable {
        Driver.get().get(ConfigurationReader.get(page));
        Driver.get().manage().window().maximize();
    }

    @When("^User create account valid credentials \"([^\"]*)\" \"([^\"]*)\"$")
    public void userCreateAccountValidCredentials(String Email, String password) throws Throwable {
        SignUpPage signUpPage = new SignUpPage();
        Assert.assertTrue(signUpPage.create_Account(Email, password));
    }

    @Then("^Verify user able create account$")
    public void verifyUserAbleCreateAccount() {
        DashboardPage dashboardPage = new DashboardPage();
        Assert.assertTrue(dashboardPage.verfiy_Title());
    }

    @When("^User create account valid credentials \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void userCreateAccountValidCredentials(String fullName, String Email, String country, String phoneNumber) throws Throwable {
        CheckOutPage onBoardPage = new CheckOutPage();
        Assert.assertTrue(onBoardPage.createAccountOnboard(fullName, Email, country, phoneNumber));
    }

    @And("^User able to check payment credentials \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void userAbleToCheckPaymentCredentials(String creditCard, String expiry, String CV) throws Throwable {
        CheckOutPage onBoardPage = new CheckOutPage();
        Assert.assertTrue(onBoardPage.check_payment(creditCard, expiry, CV));
    }
}
