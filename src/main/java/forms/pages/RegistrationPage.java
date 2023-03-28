package forms.pages;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import forms.HelpForm;
import org.openqa.selenium.By;

import java.util.Collections;
import java.util.List;

public class RegistrationPage extends Form {

    private final HelpForm HELP_FORM = new HelpForm();
    private final ITextBox PASSWORD_TEXT_BOX = getElementFactory()
            .getTextBox(By.xpath("//input[@placeholder='Choose Password']"), "Password");
    private final ITextBox EMAIL_USERNAME_TEXT_BOX = getElementFactory()
            .getTextBox(By.xpath("//input[@placeholder='Your email']"), "Email Name");
    private final ITextBox EMAIL_DOMAIN_NAME_TEXT_BOX = getElementFactory()
            .getTextBox(By.xpath("//input[@placeholder='Domain']"), "Email Domain Name");
    private final ICheckBox TERMS_AND_CONDITIONS_CHECK_BOX = getElementFactory()
            .getCheckBox(By.xpath(".//span[@class='checkbox__box']"), "Terms & Conditions Checkbox");
    private final IButton DROPDOWN_EXTENSIONS_BUTTON = getElementFactory()
            .getButton(By.xpath("//div[@class='dropdown__opener']"), "Dropdown Extensions Button");
    private final IButton NEXT_PAGE_BUTTON = getElementFactory()
            .getButton(By.xpath(".//a[@class='button--secondary']"), "Next Page Button");
    private final IButton ACCEPT_COOKIES_BUTTON = getElementFactory()
            .getButton(By.xpath(".//button[contains(@class, 'transparent')]"), "Accept Cookies Button");
    private final List<IButton> EXTENSIONS_BUTTONS = getElementFactory()
            .findElements(By.xpath("//div[@class='dropdown__list-item']"), IButton.class, ElementState.EXISTS_IN_ANY_STATE);
    private final ITextBox TIMER_TEXT_BOX = getElementFactory()
            .getTextBox(By.xpath(".//div[contains(@class, 'timer--white')]"), "Timer");

    public RegistrationPage() {
        super(By.xpath(".//div[contains(@class, 'timer')]"), "First Page");
    }

    public void selectEmailExtension() {
        DROPDOWN_EXTENSIONS_BUTTON.click();
        Collections.shuffle(EXTENSIONS_BUTTONS);
        EXTENSIONS_BUTTONS.get(0).getJsActions().scrollIntoView();
        EXTENSIONS_BUTTONS.get(0).click();
    }

    public void hideHelpForm() {
        HELP_FORM.hideHelpForm();
    }

    public boolean isHideFormDisplayed() {
        return HELP_FORM.state().isDisplayed();
    }

    public void acceptCookies() {
        ACCEPT_COOKIES_BUTTON.state().waitForDisplayed();
        ACCEPT_COOKIES_BUTTON.click();
    }

    public boolean isCookiesDisplayed() {
        return ACCEPT_COOKIES_BUTTON.state().isDisplayed();
    }

    public String getCurrentTimeOnTimer() {
        return TIMER_TEXT_BOX.getText();
    }

    public void typePassword(String password) {
        PASSWORD_TEXT_BOX.clearAndType(password);
    }

    public void typeEmailUserName(String emailUserName) {
        EMAIL_USERNAME_TEXT_BOX.clearAndType(emailUserName);
    }

    public void typeEmailDomainName(String emailDomainName) {
        EMAIL_DOMAIN_NAME_TEXT_BOX.clearAndType(emailDomainName);
    }

    public void acceptTermsAndConditions() {
        TERMS_AND_CONDITIONS_CHECK_BOX.click();
    }

    public void clickNextPageButton() {
        NEXT_PAGE_BUTTON.click();
    }
}

