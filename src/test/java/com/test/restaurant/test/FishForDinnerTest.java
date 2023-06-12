package com.test.restaurant.test;

import com.test.restaurant.page.FishAndSeafoodPage;
import com.test.restaurant.page.FishForDinnerPage;
import com.test.restaurant.page.RestaurantMainPage;
import org.testng.annotations.Test;

public class FishForDinnerTest extends RestaurantTestBase{

    @Test
    public void validateTitleFood() throws InterruptedException {

        RestaurantMainPage restaurantMainPage = new RestaurantMainPage(driver);
        restaurantMainPage.selectOption(driver,"Fish & Seafood");

        FishAndSeafoodPage fishAndSeafoodPage = new FishAndSeafoodPage(driver);
        fishAndSeafoodPage.searchBar(driver,"Fish for dinner");

        FishForDinnerPage forDinnerPage = new FishForDinnerPage(driver);
        forDinnerPage.bestChoiceValidateTitle(driver,"6-Ingredient Roasted Salmon Fillets");
    }
}
