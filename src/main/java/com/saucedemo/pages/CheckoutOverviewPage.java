package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutOverviewPage extends BaseSauceDemoPage {
    public CheckoutOverviewPage() {
        super("/checkout-step-two.html");
    }

    private final By inventoryItems = By.className("inventory_item_name");
    private final By summaryTotalLabel = By.className("summary_total_label");
    private final By cartButton = By.xpath("//*[contains(@class,'cart_button')]");

    public List<WebElement> getShoppingCartItems() { return driver().findElements(inventoryItems); }
    public String getTotalLabelText() {
        return driver().findElement(summaryTotalLabel).getText();
    }
    public void clickFinish() {
        driver().findElement(cartButton).click();
    }
}
