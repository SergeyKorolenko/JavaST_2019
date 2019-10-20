package by.korolenko.composite.service.polska;

import org.testng.annotations.Test;

public class ReversePolishNotationTest {

    @Test
    public void convertToRPN() {
        ReversePolishNotation rpn = new ReversePolishNotation();
        String expression = "(111^5|1&2<<(2|5>>2&71))|1200";
        String expected = rpn.convertToRPN(expression);
        System.out.println(expected);
    }
}
