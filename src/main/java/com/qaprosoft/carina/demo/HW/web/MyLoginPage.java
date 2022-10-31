package com.qaprosoft.carina.demo.HW.web;


import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MyLoginPage extends AbstractPage {

  @FindBy(className = "error-message-container")
    private ExtendedWebElement errorMessage;

    @FindBy(id="login-button")
    private ExtendedWebElement loginButton;

    @FindBy(id = "user-name")
    private ExtendedWebElement usernameField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordField;

    public MyLoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public void inputLogin(String login) {
        usernameField.click();
        usernameField.type(login);
    }

    public void inputPassword(String password) {
        passwordField.click();
        passwordField.type(password);
    }

    public boolean readErrorMessage(String message) {
        assertElementPresent(errorMessage);
        return errorMessage.getText().equals(message);
    }

    public void clickLoginButton() {
        loginButton.click();
        //  return new MainPage(driver);
    }
}
