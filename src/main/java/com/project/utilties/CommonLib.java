package com.project.utilties;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class CommonLib {

    public static WebDriver oDriver ;

    public CommonLib(WebDriver oDriver) {
        this.oDriver = oDriver;
        PageFactory.initElements(Driver.get(),this);
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //This method is used to wait certain second on the page
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //This method is used to validate if an element is displayed and will update the report accordingly
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean checkElementDisplayed(WebElement identifier)
    {
        boolean status = false;
        CommonLib.waitFor(1);
        try
        {
            if(identifier.isDisplayed()) {
                status = true;
            }
        }
        catch (Exception e) {
            System.out.println("Element is not found");
        }
        return status;
    }


    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(element).perform();
    }

    /**
     * Checks or unchecks given checkbox
     *
     * @param element
     * @param check
     */
    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //This method is used to scroll to element way which you want
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void scrollElementRightOrLeft(WebDriver oDriver,String direction, WebElement element) throws IOException {
        int x = element.getLocation().getX();
        int y = element.getLocation().getY();

        if (direction.equalsIgnoreCase("left")) {
            TouchAction touchAction = new TouchAction((PerformsTouchActions) oDriver).press(point(x, y)).waitAction(waitOptions(ofSeconds(2)));
            touchAction.moveTo(point(0, y)).release().perform();
        } else if (direction.equalsIgnoreCase("right")) {
            TouchAction touchAction = new TouchAction((PerformsTouchActions) oDriver).press(point(x, y)).waitAction(waitOptions(ofSeconds(2)));
            touchAction.moveTo(point(x + 100, y)).release().perform();
        } else if (direction.equalsIgnoreCase("up")) {
            TouchAction touchAction = new TouchAction((PerformsTouchActions) oDriver).press(point(x, y)).waitAction(waitOptions(ofSeconds(2)));
            touchAction.moveTo(point(x, 0)).release().perform();
        } else if (direction.equalsIgnoreCase("down")) {
            TouchAction touchAction = new TouchAction((PerformsTouchActions) oDriver).press(point(x, y)).waitAction(waitOptions(ofSeconds(2)));
            touchAction.moveTo(point(x, y + 100)).release().perform();
        }
    }


}
