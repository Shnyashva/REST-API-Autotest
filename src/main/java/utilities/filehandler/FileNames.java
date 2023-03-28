package utilities.filehandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FileNames {

    TEST_DATA("test_data.json"),
    TEST_POST("post.json"),
    AVATAR("avatar.png"),
    UPLOAD_IMAGE("uploadimage.exe"),
    STRING_GENERATOR_DATA("string_generator_data.json");

    private final String fileName;
}