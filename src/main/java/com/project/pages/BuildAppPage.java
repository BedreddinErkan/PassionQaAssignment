package com.project.pages;


import com.project.utilties.CommonLib;
import com.project.utilties.Driver;
import com.project.utilties.ScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BuildAppPage  extends BasePage {

    @FindBy(xpath = "//select[@name='category']")
    WebElement AppCategory;

    @FindBy(linkText = "Learn Spanish The Quick Way")
    WebElement EducationCategoryPageTitle;

    @FindBy(xpath = "//h1[@class='sc-bdfBwQ fmFvGz sc-eGCarw hNlgCV']")
    WebElement BusinessCategoryTitle;

    @FindBy(xpath = "//h1[@class='sc-bdfBwQ koBpIg sc-eGCarw hNlgCV']")
    WebElement FoodCategoryTitle;

    @FindBy(xpath = "//div[@class='sc-pItiW hVjObI']")
    List<WebElement> ThemeOptions;

    public boolean select_AppCategoty(String category){
        boolean status = false;
        try {
            if (Driver.get().findElement(By.xpath("//select[@name='category']/option[@value='"+category+"']")).isDisplayed()){
                    Driver.get().findElement(By.xpath("//select[@name='category']/option[@value='"+category+"']")).click();
                    status=true;
                }else {
                    ScreenShot.takeSnapShot("App Category "+category+"is not visible");

            }
        }catch (Exception e){}

        ScreenShot.takeSnapShot(category+ " is verified");
        CommonLib.waitFor(5);
        return status;
    }

    public boolean Verify_AppCategory(String category){
        boolean status = false;

        switch (category){
            case "education":
                if (EducationCategoryPageTitle.getText().contains("Learn Spanish The Quick")){
                    status=true;
            }else {
                    ScreenShot.takeSnapShot(category+" category title is not expected");
                }
            case "business":
                if (CommonLib.checkElementDisplayed(BusinessCategoryTitle)){
                    if (BusinessCategoryTitle.getText().contains("Double Your")){
                        status=true;
                    }else {
                        ScreenShot.takeSnapShot(category+" title is not expected");
                    }
                }else {
                    ScreenShot.takeSnapShot(category+" title is not displayd");
                }
            case "food_and_drink":
                if (CommonLib.checkElementDisplayed(FoodCategoryTitle)){
                    if (FoodCategoryTitle.getText().contains("Your Diet.")){
                        status=true;
                    }else {
                        ScreenShot.takeSnapShot(category+" title is not expected");
                    }
                }
        }
        return status;
    }
}
