package menuburger;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import models.CredentialsModel;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.account.MainPage;
import pageobjects.shopping.ShoppingPage;
import pageobjects.topmenu.TopMenuPage;
import utilities.Base;
import utilities.DataReader;

public class LogoutTest extends Base {
    private MainPage mainPage;
    private ShoppingPage shoppingPage;
    private TopMenuPage topMenuPage;

    @BeforeMethod(alwaysRun = true, description = "setting up the driver")
    public void setUp() {
        setup();
    }

    @Test(dataProvider = "test data", groups = {"regression", "smoke"})
    @Description("Test to verify the logout functionality")
    @Severity(SeverityLevel.BLOCKER)
    @Parameters({"credentials"})
    @TmsLink("ksBWkBLx")
    public void logoutTest(CredentialsModel credentialsModel) {
        mainPage = new MainPage(driver);
        mainPage.login(credentialsModel.getUsername(), credentialsModel.getPassword());

        shoppingPage = new ShoppingPage(driver);
        Assert.assertTrue(shoppingPage.titleIsDisplayed());

        topMenuPage = new TopMenuPage(driver);
        topMenuPage.logout();

        Assert.assertTrue(mainPage.buttonImageIsDisplayed(),
                "Bot image is not displayed");
    }

    @AfterMethod(alwaysRun = true, description = "tearing down the driver")
    public void tearDown() {
        teardown();
    }

    @DataProvider(name = "test data")
    public Object[][] dataProvider() {
        DataReader dataReader = new DataReader();

        return new Object[][]{
                {dataReader.getValidCredentials()}
        };
    }
}
