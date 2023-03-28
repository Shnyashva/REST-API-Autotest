import forms.pages.RegistrationPage;
import forms.pages.HomePage;
import forms.pages.AvatarUploadPage;
import forms.pages.PersonalDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.stringgenerator.EmailGenerator;
import utilities.stringgenerator.PasswordGenerator;

public class RegistrationTest extends BaseTest {

    @Test
    public void runTest() {
        RegistrationPage registrationPage;
        AvatarUploadPage avatarUploadPage;
        PersonalDetailsPage personalDetailsPage;
        EmailGenerator emailGenerator;
        PasswordGenerator passwordGenerator;

        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickNextPageLink();
        registrationPage = new RegistrationPage();
        Assert.assertTrue(registrationPage.state().waitForDisplayed(), "The '1' card is not open");

        emailGenerator = new EmailGenerator();
        passwordGenerator = new PasswordGenerator();
        registrationPage.hideHelpForm();
        String emailUserName = emailGenerator.generateEmailUserName();
        String emailDomainName = emailGenerator.generateEmailDomainName();
        String password = passwordGenerator.generatePassword(emailUserName);
        registrationPage.typePassword(password);
        registrationPage.typeEmailUserName(emailUserName);
        registrationPage.typeEmailDomainName(emailDomainName);
        registrationPage.selectEmailExtension();
        registrationPage.acceptTermsAndConditions();
        registrationPage.clickNextPageButton();
        avatarUploadPage = new AvatarUploadPage();
        Assert.assertTrue(avatarUploadPage.state().waitForDisplayed(), "The '2' card is not open");

        avatarUploadPage.uploadAvatar();
        avatarUploadPage.chooseInterests();
        avatarUploadPage.clickNextButton();
        personalDetailsPage = new PersonalDetailsPage();
        Assert.assertTrue(personalDetailsPage.state().waitForDisplayed(), "The '3' card is not open");
    }
}
