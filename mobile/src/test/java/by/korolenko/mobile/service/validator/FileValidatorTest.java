package by.korolenko.mobile.service.validator;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class FileValidatorTest {

    FileValidator fileValidator = new FileValidator();

    @DataProvider(name = "dataForFile")
    public Object[][] createDataForRead() {
        return new Object[][]{
                {"data/test.txt", true},
                {"data/noFile.txt", false},
        };
    }

    @Test(description = "validate file", dataProvider = "dataForFile")
    public void isFileTest(String fileName, boolean result) {
        boolean actual = fileValidator.isFile(new File(fileName));
        boolean expected = result;
        assertEquals(actual, expected);
    }
}
