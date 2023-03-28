package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {

    private final IButton SEND_TO_BOTTOM_BUTTON = getElementFactory()
            .getButton(By.xpath(".//button[contains(@class, 'send')]"),"Send To Bottom Button");

    public HelpForm() {
        super(By.xpath(".//button[contains(@class, 'close')]"),"Help Form");
    }

    public void hideHelpForm() {
        SEND_TO_BOTTOM_BUTTON.click();
        this.state().waitForNotDisplayed();
    }
}
