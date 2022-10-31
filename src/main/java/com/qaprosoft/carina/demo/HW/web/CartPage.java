package com.qaprosoft.carina.demo.HW.web;


import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractPage { //backpack

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    private ExtendedWebElement backpackPriceLabel;

    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]")
    private ExtendedWebElement backpackNameLabel;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getBackpackPrice() {
        return backpackPriceLabel.getText();
    }

    public String getBackpackName() {
        return backpackNameLabel.getText();
    }

}
