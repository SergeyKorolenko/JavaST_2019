package by.korolenko.mobile.service.input;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class FileDataReaderTest {

    FileDataReader fileDataReader = new FileDataReader();

    @DataProvider(name = "dataForRead")
    public Object[][] createDataForRead() {
        return new Object[][]{
                {"data/test.txt", 3},
                {"data/noFile.txt", 0},
        };
    }

    @Test(description = "check reading from file", dataProvider = "dataForRead")
    public void readDataTest(String fileName, int size) {
        List<String> actual = fileDataReader.readData(fileName);
        int expected = size;
        assertEquals(actual.size(), expected);
    }
}
