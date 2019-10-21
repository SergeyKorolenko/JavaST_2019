package by.korolenko.composite.service.input;

import static org.testng.Assert.assertEquals;

import by.korolenko.composite.service.exception.ProblemFileException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FileDataReaderTest {

    @DataProvider(name = "dataForReadFromFile")
    public Object[][] createDataForStringParser() {
        return new Object[][]{
                {"data/test1.txt", "\tIt has survived - not only (five) centuries, but also the leap into 13<<2 electronic typesetting, remaining 30>>>3 essentially ~6&9|(3&4) unchanged."}
        };
    }

    @Test(description = "method for reading from file",
            dataProvider = "dataForReadFromFile")
    public void readDataTest(String file, String expected) throws ProblemFileException {
        FileDataReader fr = new FileDataReader();
        String actual = fr.readData(file);
        assertEquals(actual, expected);
    }
}
