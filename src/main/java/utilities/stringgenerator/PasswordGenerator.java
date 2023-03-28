package utilities.stringgenerator;

import org.apache.commons.lang3.RandomStringUtils;
import utilities.TestDataManager;

public class PasswordGenerator {

    private final TestDataManager DATA = new TestDataManager();

    public String generatePassword(String email) {
        StringBuilder password = new StringBuilder();

        char[] capitalLetters = ("ABCDEFGHIJKLMNOPQRSTUVWXY".toCharArray());

        char[] lowerCaseLetters = ("abcdefghijklmnopqrstuvwxyz".toCharArray());

        char[] numbers = ("0123456789".toCharArray());

        char[] cyrillicLetters = ("АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуйхцчшщъыьэюя".toCharArray());

        char[] emailUserName = email.toCharArray();

        String upperCaseLetters = RandomStringUtils
                .random(DATA.getNumberOfCharactersToGenerateRegistrationData("/numberOfUpperCaseLettersForThePassword"), capitalLetters);

        String digits = RandomStringUtils
                .random(DATA.getNumberOfCharactersToGenerateRegistrationData("/numberOfDigitsForThePassword"), numbers);

        String randomString = RandomStringUtils
                .random(DATA.getNumberOfCharactersToGenerateRegistrationData("/numberOfLowerCaseLettersForThePassword"), lowerCaseLetters);

        String cyrillicCharacters = RandomStringUtils
                .random(DATA.getNumberOfCharactersToGenerateRegistrationData("/numberOfCyrillicForThePassword"), cyrillicLetters);

        String charactersFromEmail = RandomStringUtils
                .random(DATA.getNumberOfCharactersToGenerateRegistrationData("/numberOfLettersFromEmailForThePassword"), emailUserName);

        password.append(upperCaseLetters);
        password.append(cyrillicCharacters);
        password.append(digits);
        password.append(randomString);
        password.append(charactersFromEmail);

        return password.toString();
    }
}
