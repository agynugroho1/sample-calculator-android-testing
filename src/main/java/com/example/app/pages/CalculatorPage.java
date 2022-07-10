package com.example.app.pages;

import static com.example.app.drivers.AndroidDriverInit.driver;

import com.example.app.base.BasePageObject;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends BasePageObject {

  public String getTitle() {
//    By locator = MobileBy.xpath(
//        "//android.view.ViewGroup[@resource-id='com.isl.simpleapp:id/toolbar']//android.widget.TextView");
//    AndroidElement labelTitle = driver.findElement(locator);
//    return labelTitle.getText();
    return getText(MobileBy.xpath("//android.view.ViewGroup[@resource-id='com.isl.simpleapp:id/toolbar']//android.widget.TextView"));
  }

  public void inputNumberOne(int one){
    type(MobileBy.id("et_1"), String.valueOf(one));
  }

  public void inputNumbertwo(int two){
    type(MobileBy.id("et_2"), String.valueOf(two));
  }

  public String getResult(){
    return getText(MobileBy.id("tv_result"));
  }

  public void clickEqualsButton(){
    click(MobileBy.id("acb_calculate"));
  }

  public void clickChooseOperator(){
    click(MobileBy.id("spinner_1"));
  }

  public void clickOperator(String operator){
    click(MobileBy.xpath("//*[@text=\""+operator+"\"]"));
  }

  public void inputNegativeNumberOne(String one){
    type(MobileBy.id("et_1"), one);
  }

  public void inputNegativeNumberTwo(String two){
    type(MobileBy.id("et_1"), two);
  }

  public String getValueFieldNumberOne(){
    return getText(MobileBy.id("et_1"));
  }

  public String getValueFieldNumberTwo(){
    return getText(MobileBy.id("et_1"));
  }

  public Boolean checkEqualsButton(){
    return isEnabled(MobileBy.id("acb_calculate"));
  }

  public boolean checkHamburgerBtnAppear() {
//    By locator = MobileBy.AccessibilityId("Open navigation drawer");
//    AndroidElement hamburgerBtn = driver.findElement(locator);
//    return hamburgerBtn.isDisplayed();

    //explicit wait
    By locator = MobileBy.AccessibilityId("Open navigation drawer");
    WebDriverWait wait = new WebDriverWait(driver, 10, 1000);
    AndroidElement hamburgerBtn = (AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    return hamburgerBtn.isDisplayed();
  }

}
