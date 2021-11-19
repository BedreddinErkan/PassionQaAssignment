package com.project.pages;

import com.project.utilties.CommonLib;
import com.project.utilties.Driver;
import com.project.utilties.ScreenShot;
import gherkin.lexer.Tr;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage {

    @FindBy(xpath = "//input[@placeholder='Full Name']")
    WebElement FullNameInput;

    @FindBy(xpath = "//input[@placeholder='email']")
    WebElement EmailInput;

    @FindBy(xpath = "//input[@placeholder='Phone Number']")
    WebElement PhoneNumberInput;

    @FindBy(id = "card-number-element")
    WebElement CreditCardInput;

    @FindBy(xpath = "//input[@name='exp-date']")
    WebElement expiryDateInput;

    @FindBy(id = "card-cvc-element")
    WebElement CVcodeInput;

    @FindBy(xpath = "//a[@href='#submit-form']")
    WebElement SubmitButton;


    public boolean createAccountOnboard(String FullName,String Email,String country,String PhoneNumber){
        boolean status = false;

        if (CommonLib.checkElementDisplayed(FullNameInput)){
            FullNameInput.sendKeys(FullName);
            status=true;
        }else {
            ScreenShot.takeSnapShot("Test is failed");
        }

        if (CommonLib.checkElementDisplayed(EmailInput)){
            EmailInput.sendKeys(Email);
            status=true;
        }else {
            ScreenShot.takeSnapShot("Test is failed");
        }

        if (CommonLib.checkElementDisplayed(PhoneNumberInput)){
            PhoneNumberInput.sendKeys(PhoneNumber);
            status=true;
        }else {
            ScreenShot.takeSnapShot("Test is failed");
        }

        if (Driver.get().findElement(By.xpath("//select[@name='country']/option[@value='"+country+"']")).isDisplayed()){
            Driver.get().findElement(By.xpath("//select[@name='country']/option[@value='"+country+"']")).click();
            status=true;
        }else {
            ScreenShot.takeSnapShot("Test is failed");
        }
        return status;
    }

    public boolean check_payment(String creditCard,String Expiry,String CV){
        boolean status = false;

        if (CommonLib.checkElementDisplayed(CreditCardInput)){
            CreditCardInput.sendKeys(creditCard);
            status=true;
        }else {
            ScreenShot.takeSnapShot("Test is failed");
        }

        if (CommonLib.checkElementDisplayed(expiryDateInput)){
            expiryDateInput.sendKeys(Expiry);
            status=true;
        }else {
            ScreenShot.takeSnapShot("Test is failed");
        }

        if (CommonLib.checkElementDisplayed(CVcodeInput)){
            CVcodeInput.sendKeys(CV);
            status = true;
        }else {
            ScreenShot.takeSnapShot("Test is failed");
        }
        ScreenShot.takeSnapShot("Credentails are verified");
        CommonLib.waitFor(2);
        if (CommonLib.checkElementDisplayed(SubmitButton)){
            SubmitButton.click();
            status=true;
        }else {
            ScreenShot.takeSnapShot("Test is failed");
        }
        return status;
    }
}
