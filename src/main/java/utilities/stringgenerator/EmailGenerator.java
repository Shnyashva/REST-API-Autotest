package utilities.stringgenerator;

import org.apache.commons.lang3.RandomStringUtils;
import utilities.TestDataManager;

public class EmailGenerator {

    private final TestDataManager DATA = new TestDataManager();
    char[] possibleCharacters = ("ABCDEFGHIJKLMNOPQRSTUVWXYabcdefghijklmnopqrstuvwxyz0123456789".toCharArray());

    public String generateEmailUserName() {
        return RandomStringUtils.random(DATA.getNumberOfCharactersToGenerateRegistrationData("/numberOfCharactersForTheEmailUserName"),
                0, possibleCharacters.length - 1, true, false, possibleCharacters);
    }

    public String generateEmailDomainName() {
        return RandomStringUtils.random(DATA.getNumberOfCharactersToGenerateRegistrationData("/numberOfCharactersForTheEmailDomainName"),
                0, possibleCharacters.length - 1, true, true, possibleCharacters);
    }
}
