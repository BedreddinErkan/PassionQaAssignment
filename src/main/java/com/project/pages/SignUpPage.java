package com.project.pages;

import com.project.utilties.CommonLib;
import com.project.utilties.ScreenShot;
import gherkin.lexer.Tr;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignUpPage {

    @FindBy(xpath = "//input[@type='email']")
    WebElement EmailInput;

    @FindBy(xpath = "//input[@type='password']")
    WebElement PasswordInput;

    @FindBy(xpath = "//input[@placeholder='Type your password again']")
    WebElement SecondPasswordInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement SubmitBtn;




    public boolean create_Account(String Email,String password){
        boolean status = false;

        if (CommonLib.checkElementDisplayed(EmailInput)){
            EmailInput.sendKeys(Email);
            status=true;
        }else {
            ScreenShot.takeSnapShot("Email account is not visible");
        }

        CommonLib.waitFor(3);

        if (CommonLib.checkElementDisplayed(PasswordInput)){
            PasswordInput.sendKeys(password);
            status=true;
        }else {
            ScreenShot.takeSnapShot("Password ınput is not visible");
        }

        CommonLib.waitFor(3);

        if (CommonLib.checkElementDisplayed(SecondPasswordInput)){
            SecondPasswordInput.sendKeys(password);
            status=true;
        }else {
            ScreenShot.takeSnapShot("Second password is not visible");
        }

        if (CommonLib.checkElementDisplayed(SubmitBtn)){
            SubmitBtn.click();
            status=true;
        }else {
            ScreenShot.takeSnapShot("Create Accunt button displayed");
        }

        return status;
    }


}
