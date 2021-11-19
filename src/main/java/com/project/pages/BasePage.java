package com.project.pages;

import com.project.utilties.CommonLib;
import com.project.utilties.ScreenShot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {

    @FindBy(xpath = "//h1[@class='fz-76 text-white']")
    WebElement ChooseYourPlanTitle;


    public boolean verfiy_Title(){
        boolean status=false;

        if (CommonLib.checkElementDisplayed(ChooseYourPlanTitle)){
            status=true;
        }else {
            ScreenShot.takeSnapShot("Choose Your Plan");
        }
        return status;
    }
}
