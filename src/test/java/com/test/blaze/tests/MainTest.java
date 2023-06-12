package com.test.blaze.tests;

import com.test.blaze.pages.CartPage;
import com.test.blaze.pages.LaptopsPage;
import com.test.blaze.pages.MainBlazePage;
import com.test.openchart.pages.MainPage;
import org.testng.annotations.Test;

public class MainTest extends BlazeTestBase {

    @Test
    public void testMainPage() throws InterruptedException {

        MainBlazePage mainBlazePage = new MainBlazePage(driver);
        mainBlazePage.categoryOption("Laptops");

        LaptopsPage laptopsPage = new LaptopsPage(driver);
        laptopsPage.laptopChoice(driver,"MacBook Pro");

        laptopsPage.checkInfo("MacBook Pro", "$1100 *includes tax",
                "Product description\n" +
                "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");

        laptopsPage.addToCart(driver , "Product added");

    }
}
