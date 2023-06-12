package com.test.restaurant.test;

import com.test.restaurant.page.RestaurantMainPage;
import org.testng.annotations.Test;

public class MainTests extends RestaurantTestBase {

    @Test
    public void getSeaFood() throws InterruptedException {

        RestaurantMainPage restaurantMainPage = new RestaurantMainPage(driver);

        restaurantMainPage.selectOption(driver,"Fish & Seafood");


    }
}
