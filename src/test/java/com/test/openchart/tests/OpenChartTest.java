package com.test.openchart.tests;

import com.test.openchart.pages.OpenChartPage;
import org.testng.annotations.Test;

public class OpenChartTest extends OpenChartTestBase{


    @Test
    public void happyPathLogin() throws InterruptedException {

        OpenChartPage openChartPage = new OpenChartPage(driver);

        openChartPage.loginPageFunction(driver ,"demo" ,"demo" );

    }
    @Test
    public void negativeLogin() throws InterruptedException {
        OpenChartPage openChartPage = new OpenChartPage(driver);

        openChartPage.loginPageFunction(driver,"demo" , "dem");


    }


}
