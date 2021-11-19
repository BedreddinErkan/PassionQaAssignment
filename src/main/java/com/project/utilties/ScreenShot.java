package com.project.utilties;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;


public class ScreenShot extends Driver

{



       public static  String filePath                 =System.getProperty("user.dir")+"/ScreenShots";

       public  final static String      path          = filePath;
       public static  int                imgNo;
       public static  String             startImgNo   = "1";
       public  static String             endImgNo;
       public static String folderPath;
       public  static String             testName;
       public static Scenario scenario;


       public static void takeSnapShot(String elementName)
       {
              try
              {
                     if(driver != null){
                            CommonLib.waitFor(2);
                            TakesScreenshot scrShot = ((TakesScreenshot) driver);
                            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
                            File DestFile = new File(folderPath + "//" + imgNo+elementName + ".png");
                            FileUtils.copyFile(SrcFile, DestFile);
                            System.out.println("scenario name:"+scenario.getName());
                            if(startImgNo.equalsIgnoreCase("stepComplete"))
                                   startImgNo = imgNo + "";
                            endImgNo = imgNo + "";
                            imgNo++;
                            com.cucumber.listener.Reporter.addScreenCaptureFromPath(DestFile.toString());
                     }


                     assert driver != null;
                     final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                     scenario.embed(screenshot,"image/png");
              }
              catch(Exception e)
              {
                     e.printStackTrace();
              }
       }




       public static void createFolder()

       {
              //.folderName.ring scenarioName = scenario.getName();
//            String[] folderName1 = scenario.split(Pattern.quote("-"));

//            String folderName = folderName1[1];
              String folderName ="TC00";
              int dirNo = 1;
              //String envFolder = "Test";// + Browser.setEnvURL.charAt(0) + Browser.setEnvURL.charAt(1);
              //System.out.println(folderName);
              java.util.Date date = new java.util.Date();
              String[] as = date.toString().split(" ");
              String todaysDate = as[2] + " " + as[1] + " " + as[5];
              folderPath = path + "//" + todaysDate + "//" + folderName;
              testName = folderName;
              boolean flag = true;
              while(flag)
              {
                     File dir = new File(folderPath);
                     if(dir.exists())
                     {
                            testName = folderName + "_" + dirNo;
                            folderPath = path + "//" + todaysDate + "//" + "//" + testName;
                            dirNo++;
                     }
                     else
                     {
                            dir.mkdirs();
                            flag = false;
                     }
              }
              imgNo = 1;
              //GenerateReport.setReportName(true);
       }

}
