import aquality.selenium.browser.AqualityServices;
import forms.pages.HomePage;
import org.testng.annotations.*;
import utilities.TestDataManager;

public class BaseTest {
    protected HomePage homePage;

    @BeforeMethod
    public void setUp() {
        TestDataManager data = new TestDataManager();
        AqualityServices.getBrowser().goTo(data.getTestData("/url"));
    }

    @AfterMethod
    public void tearDown() {
        AqualityServices.getBrowser().quit();
    }
}
