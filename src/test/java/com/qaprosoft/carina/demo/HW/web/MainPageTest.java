/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.HW.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class MainPageTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(MainPageTest.class.getName());

    MyLoginPage loginPage;
    MainPage mainPage;
    CartPage cartPage;
    ItemPage itemPage;

    @BeforeTest
    public void startDriver() {
        loginPage = new MyLoginPage(getDriver());
    }

    @Test
    @MethodOwner(owner = "diana")
    @TestLabel(name = "3. login, add to cart item(backpack) and check price/name", value = {"web"})
    public void addToCartTest() {

        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");// login page
        loginPage.inputLogin("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        mainPage = new MainPage(getDriver());
        Assert.assertTrue(mainPage.backpackItemVisibility());
        String price = mainPage.getBackpackPrice();
        String itemName = mainPage.getBackpackName();

        mainPage.clickAddToCartButton();
        mainPage.clickCartButton();

        cartPage = new CartPage(getDriver());
        Assert.assertEquals(itemName, cartPage.getBackpackName());
        Assert.assertEquals(price, cartPage.getBackpackPrice());

        //  LOGGER.info(itemName + " = " + cartPage.getBackpackName());
        // LOGGER.info(price + " = " + cartPage.getBackpackPrice());
    }

    @Test
    @MethodOwner(owner = "diana")
    @TestLabel(name = "4. login, open item(Onesie), check price/name and logout", value = {"web"})
    public void openItemTest() {

        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");// login page
        loginPage.inputLogin("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        mainPage = new MainPage(getDriver());
        Assert.assertTrue(mainPage.isOnesieItemVisible());
        String price = mainPage.getOnesiePrice();
        String itemName = mainPage.getOnesieName();
        mainPage.clickTitleToOpenShirtLink();//open item

        itemPage = new ItemPage(getDriver());
        Assert.assertEquals(itemName, itemPage.getOnesieName());
        Assert.assertEquals(price, itemPage.getOnesiePrice());

        // LOGGER.info(itemName + " = " + itemPage.getOnesieName());
        // LOGGER.info(price + " = " + itemPage.getOnesiePrice());

        itemPage.clickBackToProductsButton();
        mainPage.clickMenuButton();
        mainPage.clickLogoutButton();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");// login page
    }

    @Test
    @MethodOwner(owner = "diana")
    @TestLabel(name = "5. login, check sorting", value = {"web"})
    public void sortedTest() {

        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");// login page
        loginPage.inputLogin("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        mainPage = new MainPage(getDriver());

        List<String> sortedList = mainPage.readItemsNameList().stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(sortedList, mainPage.readItemsNameList(), "Wrong order!!");

        mainPage.clickOnSortButton("za");
        sortedList = mainPage.readItemsNameList().stream().sorted().collect(Collectors.toList());
        Collections.reverse(sortedList);
        Assert.assertEquals(sortedList, mainPage.readItemsNameList(), "Wrong order!!");
        //LOGGER.info(sortedList);

        mainPage.clickOnSortButton("az");
        sortedList = mainPage.readItemsNameList().stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(sortedList, mainPage.readItemsNameList(), "Wrong order!!");
       // LOGGER.info(sortedList);


        mainPage.clickOnSortButton("hilo");
        List<String> sortedPriceList = mainPage.readPricesList().stream()
                .map(item -> item.replaceAll("\\$", ""))
                .collect(Collectors.toList());

        List<Double> newList = sortedPriceList.stream()
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        List<Double> sortedDouble = sortedPriceList.stream()
                .map(Double::parseDouble)
                .sorted().collect(Collectors.toList());

        Collections.reverse(newList);

        Assert.assertEquals(sortedDouble, newList, "Wrong order!!");
        //LOGGER.info(sortedPriceList);
        //LOGGER.info(newList);

        mainPage.clickOnSortButton("lohi");
        sortedPriceList = mainPage.readPricesList().stream()
                .map(item -> item.replaceAll("\\$", ""))
                .collect(Collectors.toList());

        newList = sortedPriceList.stream()
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        sortedDouble = sortedPriceList.stream()
                .map(Double::parseDouble)
                .sorted().collect(Collectors.toList());

        Assert.assertEquals(sortedDouble, newList, "Wrong order!!");
       // LOGGER.info(newList);
        //LOGGER.info(sortedDouble);
    }
}
