package by.korolenko.composite.service.polska;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReversePolishNotationTest {

    private ReversePolishNotation rpn = new ReversePolishNotation();

    @DataProvider(name = "dataForRPN")
    public Object[][] createDataForStringParser() {
        return new Object[][]{
                {"~5", "5 ~"},
                {"6>>1", "6 1 >>"},
                {"13>>2", "13 2 >>"},
                {"~6&9|(3&4)", "6 ~ 9 & 3 4 & |"},
                {"(~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78",
                        "71 ~ 2 3 & 3 2 1 2 >> & 2 | 2 & | | 10 2 & | & 78 |"},
                {"(111^5|1&2<<(2|5>>2&71))|1200",
                        "111 5 ^ 1 2 2 5 2 >> 71 & | << & | 1200 |"},
                {"2<<3", "2 3 <<"},
                {"168|78", "168 78 |"},
                {"45&68", "45 68 &"}
        };
    }

    @Test(description = " method for converting to RPN",
            dataProvider = "dataForRPN")
    public void convertToRPN(String a, String b) {
        String actual = rpn.convertToRPN(a);
        assertEquals(actual, b);
    }
}
