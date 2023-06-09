package com.test.openchart.tests;

import com.test.openchart.pages.CustomersPage;
import com.test.openchart.pages.MainPage;
import com.test.openchart.pages.OpenChartPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CustomerTest extends OpenChartTestBase{

    @Test
    public void addCustomerValidation() throws InterruptedException {

        OpenChartPage openChartPage = new OpenChartPage(driver);

        openChartPage.loginPageFunction(driver ,"demo" ,"demo" );

        Thread.sleep(1000);

        MainPage mainPage = new MainPage(driver);
        mainPage.customersPage();

        CustomersPage customersPage = new CustomersPage(driver);

        customersPage.clickAddCustomer();

        customersPage.provideInformation(driver ,"Askar" ,"Imanbekov" , "aimanbekov02@gmail.com",
                "Askar2004" , "Askar2004"  );

    }

}
