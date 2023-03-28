import forms.pages.RegistrationPage;
import forms.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestDataManager;

public class TimerValidationTest extends BaseTest {

    @Test
    public void runTest() {
        RegistrationPage registrationPage;
        homePage = new HomePage();
        TestDataManager data = new TestDataManager();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickNextPageLink();
        registrationPage = new RegistrationPage();
        Assert.assertEquals(registrationPage.getCurrentTimeOnTimer(), data.getTestData("/expectedTimeOnTimer"),
                "Timer did not start from 00:00:00");
    }
}
