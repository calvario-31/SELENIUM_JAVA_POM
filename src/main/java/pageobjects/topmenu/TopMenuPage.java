package pageobjects.topmenu;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.Page;
import utilities.Log;

public class TopMenuPage extends Page {
    private final By menuBurger = By.id("react-burger-menu-btn");
    private final By buttonLogout = By.id("logout_sidebar_link");
    private final By buttonAbout = By.id("about_sidebar_link");
    private final By itemCount = By.className("shopping_cart_badge");
    private final By buttonCheckout = By.id("shopping_cart_container");

    public TopMenuPage(WebDriver driver) {
        super(driver, 5);
    }

    @Step("Getting the item count from the UI")
    public int getItemCount() {
        waitPageToLoad();
        Log.info("Getting item count text");
        String text = find(itemCount).getText();
        Log.debug("Item count test: " + text);
        return Integer.parseInt(text);
    }

    @Step("Clicking on checkout")
    public void goToCheckout() {
        Log.info("Clicking on the checkout button");
        find(buttonCheckout).click();
    }

    @Step("Getting the href from about button and verifying is enabled")
    public String getHrefFromAbout() {
        Log.info("Clicking on the menu burger");
        find(menuBurger).click();
        WebElement AboutElement = waitAndFind(buttonAbout);
        Log.info("Verifying the button is enabled");
        if (AboutElement.isEnabled()) {
            Log.info("The button is enabled, getting the href");
            return AboutElement.getAttribute("href");
        } else {
            Log.error("The button is not enabled");
            return null;
        }
    }

    @Step("Clicking on logout")
    public void logout() {
        Log.info("Clicking on the menu burger");
        find(menuBurger).click();
        Log.info("Clicking on the button logout");
        waitAndFind(buttonLogout).click();
    }

    @Override
    protected void waitPageToLoad() {
        waitAndFind(menuBurger);
    }
}
