package com.qaprosoft.carina.demo.HW.web;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends AbstractPage {

    int count = 6;
    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    private ExtendedWebElement logoutButton;
    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    private ExtendedWebElement menuButton;
    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]")
    private ExtendedWebElement cartButton;
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private ExtendedWebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"item_2_title_link\"]")
    private ExtendedWebElement titleOpenShirtLink;
    @FindBy(xpath = "//div[@class=\"pricebar\"]//div[@class=\"inventory_item_price\"]")
    private List<ExtendedWebElement> itemsPrice;
    @FindBy(xpath = "//div[@class=\"inventory_item\"]//div[@class=\"inventory_item_name\"]")
    private List<ExtendedWebElement> itemsName;
    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")
    private ExtendedWebElement backpackPriceLabel;
    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[5]/div[2]/div[2]/div")
    private ExtendedWebElement onesiePriceLabel;
    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[4]")
    private ExtendedWebElement backpackItem;
    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[5]")
    private ExtendedWebElement onesieItem;
    @FindBy(id = "item_2_title_link")
    private ExtendedWebElement onesieNameLabel;
    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    private ExtendedWebElement backpackNameLabel;
    @FindBy(xpath = "//select[@class='product_sort_container']")
    private ExtendedWebElement sortButton;
    @FindBy(xpath = "//select[@class='product_sort_container']//option[@value='%s']")
    private ExtendedWebElement filter;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getBackpackPrice() {
        return backpackPriceLabel.getText();
    }

    public String getBackpackName() {
        return backpackNameLabel.getText();
    }

    public String getOnesiePrice() {
        return onesiePriceLabel.getText();
    }

    public String getOnesieName() {
        return onesieNameLabel.getText();
    }


    public void clickOnSortButton(String text) {
        sortButton.click(200);
        filter.format(text).click(200);
    }


    public List<String> readPricesList() {
        List<String> pricesList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            pricesList.add(itemsPrice.get(i).getText());
        }
        return pricesList;
    }

    public List<String> readItemsNameList() {
        List<String> itemsNameList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            itemsNameList.add(itemsName.get(i).getText());
        }
        return itemsNameList;
    }

    public boolean isOnesieItemVisible() {
        return onesieItem.isElementPresent();
    }

    public boolean backpackItemVisibility() {
        return backpackItem.isElementPresent();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public void clickTitleToOpenShirtLink() {
        titleOpenShirtLink.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickMenuButton() {
        menuButton.click();
    }

    public void clickLogoutButton() {
        logoutButton.click(2000);
    }
}
