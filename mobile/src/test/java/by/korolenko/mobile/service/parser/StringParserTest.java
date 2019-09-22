package by.korolenko.mobile.service.parser;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringParserTest {

    StringParser stringParser = new StringParser();

    @DataProvider(name = "dataForStringParser")
    public Object[][] createDataForStringParser() {
        return new Object[][]{
                {"1,2,test,4", 4},
                {"test1,4", 2},
                {"null", 1},
                {"", 1},
        };
    }

    @Test(description = "check string parser",
            dataProvider = "dataForStringParser")
    public void parseToStringTest(String a, int b) {
        int actual = stringParser.parseToString(a).length;
        int expected = b;
        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void parseNullString() {
        stringParser.parseToString(null);
    }
}
