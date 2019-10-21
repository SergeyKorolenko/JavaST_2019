package by.korolenko.composite.service.interpreter;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExpressionParserTest {

    @DataProvider(name = "dataForCalculateRPN")
    public Object[][] createDataForStringParser() {
        return new Object[][]{
                {"5 ~", -6},
                {"6 1 >>", 3},
                {"13 2 >>", 3},
                {"6 ~ 9 & 3 4 & |", 9},
                {"71 ~ 2 3 & 3 2 1 2 >> & 2 | 2 & | | 10 2 & | & 78 |", 78},
                {"111 5 ^ 1 2 2 5 2 >> 71 & | << & | 1200 |", 1274},
                {"5 1 <<", 10},
                {"2 2 <<", 8},
                {"2 2 ^", 0},
                {"2 1 ^", 3},
                {"13 13 |", 13}
        };
    }

    @Test(description = "method for calculating expression",
            dataProvider = "dataForCalculateRPN")
    public void calculateTest(String a, int b) {
        ExpressionParser parser = new ExpressionParser(a);
        int actual = parser.calculate();
        assertEquals(actual, b);
    }
}
