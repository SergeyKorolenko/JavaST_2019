package by.korolenko.composite.service.interpreter;

import org.testng.annotations.Test;

public class ExpressionParserTest {

    @Test
    public void calculateTest() {
        String expression = "111 5 ^ 1 2 2 5 2 >> 71 & | << & | 1200 |";
        ExpressionParser parser = new ExpressionParser(expression);
        Integer result = parser.calculate();
        System.out.println(result);
    }
}
