package credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import models.CredentialsModel;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.account.MainPage;
import utilities.Base;
import utilities.DataReader;

public class BadCredentialsTest extends Base {
    private MainPage mainPage;

    @BeforeMethod(alwaysRun = true, description = "setting up the driver")
    public void setUp() {
        setup();
    }

    @Test(dataProvider = "test data", groups = {"regression", "smoke"})
    @Description("Test to verify the error message when bad credentials are used")
    @Severity(SeverityLevel.NORMAL)
    @Parameters({"credentials"})
    @TmsLink("2QtPrEKU")
    public void badCredentialsTest(CredentialsModel credentialsModel) {
        mainPage = new MainPage(driver);
        mainPage.login(credentialsModel.getUsername(), credentialsModel.getPassword());

        Assert.assertTrue(mainPage.errorMessageIsDisplayed(), "Error message was not displayed");
    }

    @AfterMethod(alwaysRun = true, description = "tearing down the driver")
    public void tearDown() {
        teardown();
    }

    @DataProvider(name = "test data")
    public Object[][] dataProvider() {
        DataReader dataReader = new DataReader();
        dataReader.getLockedCredentials();

        return new Object[][]{
                {dataReader.getLockedCredentials()}
        };
    }
}
