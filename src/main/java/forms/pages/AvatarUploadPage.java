package forms.pages;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utilities.TestDataManager;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class AvatarUploadPage extends Form {

    private final ICheckBox UNSELECT_ALL_CHECKBOX = getElementFactory()
            .getCheckBox(By.xpath(".//label[@for='interest_unselectall']"), "Unselect All");

    private final IButton UPLOAD_IMAGE_BUTTON = getElementFactory()
            .getButton(By.xpath(".//a[contains(@class, 'upload-button')]"), "Upload Image");

    private final IButton NEXT_PAGE_BUTTON = getElementFactory()
            .getButton(By.xpath(".//button[contains(@class, 'stroked')]"), "Next Page Button");

    private final List<ICheckBox> ALL_CHECKBOXES_LIST = getElementFactory()
            .findElements(By.xpath(".//label[contains(@for, 'interest')]"),
                    ICheckBox.class, ElementsCount.MORE_THEN_ZERO, ElementState.DISPLAYED);

    private final ILabel AVATAR_IMAGE = getElementFactory()
            .getLabel(By.xpath(".//div[contains(@class, 'avatar-image')]"), "Avatar Image");


    public AvatarUploadPage() {
        super(By.xpath(".//span[@class='icon icon-check checkbox__check']"), "Second Page");
    }

    public void uploadAvatar() {
        clickUploadImageButton();
        try {
            TestDataManager data = new TestDataManager();
            Runtime.getRuntime().exec(data.getUploadImageFIle());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        isAvatarImageDisplayed();
    }

    public void chooseInterests() {
        TestDataManager data = new TestDataManager();
        clickUnselectAllCheckbox();
        int numberOfInterestToChoose = Integer.parseInt(data.getTestData("/numberOfInterests"));
        int counter = 0;
        Collections.shuffle(ALL_CHECKBOXES_LIST);
        for (ICheckBox checkbox : ALL_CHECKBOXES_LIST) {
            if (checkbox.getAttribute("for").contains("selectall")) {
                continue;
            }
            if (counter < numberOfInterestToChoose) {
                checkbox.click();
                counter++;
            } else {
                break;
            }
        }
    }

    public void clickNextButton() {
        NEXT_PAGE_BUTTON.click();
    }

    public void isAvatarImageDisplayed() {
        AVATAR_IMAGE.state().waitForDisplayed();
    }

    public void clickUploadImageButton() {
        UPLOAD_IMAGE_BUTTON.clickAndWait();
    }

    public void clickUnselectAllCheckbox() {
        UNSELECT_ALL_CHECKBOX.click();
    }
}
