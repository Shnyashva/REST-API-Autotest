package forms.pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HomePage extends Form {

    private final ILink HERE_LINK = getElementFactory()
            .getLink(By.xpath(".//a[contains(@class, 'start__link')]"), "HERE Link");

    public HomePage() {
        super(By.xpath(".//button[@class='start__button']"), "Home Page");
    }

    public void clickNextPageLink() {
        HERE_LINK.click();
    }
}
