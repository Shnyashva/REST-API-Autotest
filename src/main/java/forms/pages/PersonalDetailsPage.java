package forms.pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsPage extends Form {

    public PersonalDetailsPage() {
        super(By.xpath(".//div[contains(@class, 'left selected')]"), "Third Page");
    }
}
