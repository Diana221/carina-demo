package com.qaprosoft.carina.demo.HW.web;



import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends AbstractPage { //Onesie

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]")
    private ExtendedWebElement priceOnesieLabel;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")
    private ExtendedWebElement onesieNameLabel;

    @FindBy(xpath = "//*[@id=\"back-to-products\"]")
    private ExtendedWebElement backButton;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void clickBackToProductsButton() {
        backButton.click();
    }

    public String getOnesiePrice() {
        return priceOnesieLabel.getText();
    }

    public String getOnesieName() {
        return onesieNameLabel.getText();
    }

}
