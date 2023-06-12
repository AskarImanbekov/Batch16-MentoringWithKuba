package com.test.blaze.tests;

import com.test.blaze.pages.CartPage;
import com.test.blaze.pages.LaptopsPage;
import com.test.blaze.pages.MainBlazePage;
import org.testng.annotations.Test;

public class CartPageTest extends BlazeTestBase{

    @Test
    public void testCartPage() throws InterruptedException {
        MainBlazePage mainBlazePage = new MainBlazePage(driver);
        mainBlazePage.categoryOption("Laptops");

        LaptopsPage laptopsPage = new LaptopsPage(driver);
        laptopsPage.laptopChoice(driver,"MacBook Pro");

        laptopsPage.checkInfo("MacBook Pro", "$1100 *includes tax",
                "Product description\n" +
                        "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");

        laptopsPage.addToCart(driver , "Product added");

        CartPage cartPage = new CartPage(driver);
        mainBlazePage.clickCartButton();
        cartPage.validateTitleAdnPrice(driver,"MacBook Pro","1100");
        cartPage.placeOrder(driver,"Ahmet Baldir","USA","Chicago","12345678","9","27",
                "Thank you for your purchaseasdsf!");
    }

}
