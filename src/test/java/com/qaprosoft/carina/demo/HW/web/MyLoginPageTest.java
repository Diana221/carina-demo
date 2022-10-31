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

public class MyLoginPageTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(MainPageTest.class.getName());


    MyLoginPage loginPage;
    @BeforeTest
    public void startDriver() {
        loginPage = new MyLoginPage(getDriver());
    }

    @Test
    @MethodOwner(owner = "diana")
    @TestLabel(name = "1. empty fields", value = {"web"})
    public void emptyFieldsTest() {

        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");//login page
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.readErrorMessage("Epic sadface: Username is required")); //right error message showed
    }


    @Test
    @MethodOwner(owner = "diana")
    @TestLabel(name = "2. wrong password", value = {"web"})
    public void wrongPassword() {

        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");//login page
        loginPage.inputLogin("standard_user");
        loginPage.inputPassword("password");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");//login page
        Assert.assertTrue(loginPage.readErrorMessage("Epic sadface: Username and password do not " +
                "match any user in this service")); //right error message showed
    }
}
