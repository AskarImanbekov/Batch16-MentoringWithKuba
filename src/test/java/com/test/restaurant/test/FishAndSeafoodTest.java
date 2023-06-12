package com.test.restaurant.test;

import com.test.restaurant.page.FishAndSeafoodPage;
import com.test.restaurant.page.RestaurantMainPage;
import org.testng.annotations.Test;

public class FishAndSeafoodTest extends RestaurantTestBase {

    @Test
    public void scrollAndSearch() throws InterruptedException {

        RestaurantMainPage restaurantMainPage = new RestaurantMainPage(driver);
        restaurantMainPage.selectOption(driver,"Fish & Seafood");

        FishAndSeafoodPage fishAndSeafoodPage = new FishAndSeafoodPage(driver);
        fishAndSeafoodPage.searchBar(driver,"Fish for dinner");
    }
}
