import forms.pages.RegistrationPage;
import forms.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HideHelpFormTest extends BaseTest {

    @Test
    public void runTest() {
        RegistrationPage registrationPage;
        homePage = new HomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickNextPageLink();
        registrationPage = new RegistrationPage();
        registrationPage.hideHelpForm();
        Assert.assertFalse(registrationPage.isHideFormDisplayed(), "Form content is not hidden");
    }
}
