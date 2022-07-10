package com.example.app.pages;

import com.example.app.base.BasePageObject;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

import org.openqa.selenium.Point;

import static java.time.temporal.ChronoUnit.SECONDS;

public class ListPage extends BasePageObject {

    public void swipeList() {
//    TouchAction action = new TouchAction(getDriver());
//    AndroidElement containerList = find(MobileBy.id("recycler_view"));
//    Point coordinate = containerList.getCenter();
//    PointOption start = PointOption.point(coordinate);
//    PointOption end = PointOption.point(coordinate.getX(), coordinate.getY() + -1000);
//    //builder
//    action
//        .press(start)
//        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
//        .moveTo(end)
//        .release()
//        .perform();

        AndroidElement element = find(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"List ke-60\"))"));
    }

    public void longpressList() {
        TouchAction action = new TouchAction(getDriver());
        AndroidElement elementList = find(MobileBy.id("recycler_view"));
        action.longPress(PointOption.point(elementList.getCenter()))
                .waitAction(WaitOptions.waitOptions(Duration.of(10, SECONDS))).release()
                .perform();
    }

    public void tapMultipleTimes() {
        TouchAction action = new TouchAction(getDriver());
        AndroidElement elementList = find(MobileBy.id("recycler_view"));
        action.tap(TapOptions.tapOptions().withTapsCount(10)
                        .withElement(ElementOption.element(elementList)))
                .perform();
    }
}
