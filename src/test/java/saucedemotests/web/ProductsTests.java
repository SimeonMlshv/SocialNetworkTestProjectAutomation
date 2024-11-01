package saucedemotests.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saucedemotests.core.SauceDemoBaseWebTest;
import saucedemotests.enums.TestData;

public class ProductsTests extends SauceDemoBaseWebTest {
    public final String BACKPACK_TITLE = "Sauce Labs Backpack";
    public final String SHIRT_TITLE = "Sauce Labs Bolt T-Shirt";

    @BeforeEach
    public void beforeTest(){
        // Authenticate with Standard user
    }

    @Test
    public void productAddedToShoppingCart_when_addToCart(){
        // Add products to shopping cart

        // Go to shopping cart

        // Assert Items and Totals
    }

    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation(){
        // Add products to shopping cart

        // Go to shopping cart

        // Go to checkout

        // Fill form

        // Continue

        // Assert Cart Items number

        // Calculate expected total cost

        // Assert Cart Items Titles and total cost
    }

    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm(){
        // Add Backpack and T-shirt to shopping cart

        // Click on shopping Cart

        // Go to Billing Info

        // Fill form

        // Continue

        // Assert Items removed from Shopping Cart

        // Complete Order

        // Assert Shopping cart is empty
    }
}