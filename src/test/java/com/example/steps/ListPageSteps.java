package com.example.steps;

import com.example.BaseTest;
import io.cucumber.java.en.And;

public class ListPageSteps extends BaseTest {

    @And("user do scroll")
    public void userDoScroll() {
        listPage.swipeList();
    }

    @And("user longpress one of the list")
    public void userLongpressOneOfTheList() {
        listPage.longpressList();
    }

    @And("user tap multiple times one of the list")
    public void userTapMultipleTimesOneOfTheList() {
        listPage.tapMultipleTimes();
    }
}
