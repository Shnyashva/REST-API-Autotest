package utilities;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import utilities.filehandler.FileHelper;
import utilities.filehandler.FileNames;

public class TestDataManager {

    private static final ISettingsFile TEST_DATA = new JsonSettingsFile(FileNames.TEST_DATA.getFileName());
    private static final ISettingsFile STRING_GENERATOR_DATA =
            new JsonSettingsFile(FileNames.STRING_GENERATOR_DATA.getFileName());

    public String getUploadImageFIle() {
        return FileHelper.getResourceFileByName(FileNames.UPLOAD_IMAGE.getFileName()).toString();
    }

    public int getNumberOfCharactersToGenerateRegistrationData(String path) {
        return Integer.parseInt(STRING_GENERATOR_DATA.getValue(path).toString());
    }

    public String getTestData(String path) {
        return TEST_DATA.getValue(path).toString();
    }
}
