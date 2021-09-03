package pageobjects.shopping;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.Page;
import utilities.Log;

public class ShoppingPage extends Page {
    private final By title = By.className("title");

    public ShoppingPage(WebDriver driver) {
        super(driver, 5);
    }

    @Step("Verifying the title is displayed")
    public boolean titleIsDisplayed() {
        Log.info("Verifying the title is displayed");
        return isDisplayed(title);
    }

    @Step("Going to item details of {0}")
    public void goToDetail(String productName) {
        String xpathGeneric = "//div[text()='PRODUCT_NAME']";
        String xpathItemName = xpathGeneric.replace("PRODUCT_NAME", productName);
        Log.debug("Xpath of the item name: " + xpathItemName);
        By itemName = By.xpath(xpathItemName);
        waitPageToLoad();
        Log.info("Clicking on the name to go to the item detail");
        find(itemName).click();
    }

    @Override
    protected void waitPageToLoad() {
        waitAndFind(title);
    }
}
