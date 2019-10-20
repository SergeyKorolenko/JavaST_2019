package by.korolenko.composite.service.polska;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class ReversePolishNotation {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(ReversePolishNotation.class.getName());
    /**
     * Expression regex.
     */
    private static final String EXPRESSION_REGEX =
            "[\\d]+|[|&\\^()~]|[>]+|[<]+";
    /**
     * Priority.
     */
    private Map<String, Integer> priority = new HashMap<>();

    /**
     * Max priority.
     */
    private static final int MAX_PRIORITY = 5;
    /**
     * Min priority.
     */
    private static final int MIN_PRIORITY = 0;
    /**
     * Priority 4.
     */
    private static final int PRIORITY_4 = 4;
    /**
     * Priority 3.
     */
    private static final int PRIORITY_3 = 3;
    /**
     * Priority 2.
     */
    private static final int PRIORITY_2 = 2;
    /**
     * Priority 1.
     */
    private static final int PRIORITY_1 = 1;

    {
        priority.put("~", MAX_PRIORITY);
        priority.put(">>", PRIORITY_4);
        priority.put("<<", PRIORITY_4);
        priority.put(">>>", PRIORITY_4);
        priority.put("&", PRIORITY_3);
        priority.put("^", PRIORITY_2);
        priority.put("|", PRIORITY_1);
        priority.put("(", MIN_PRIORITY);
    }

    /**
     * RPN method.
     *
     * @param expressionString expression
     * @return RPN string
     */
    public String convertToRPN(final String expressionString) {
        List<String> expression = new ArrayList<>();
        Pattern pattern = Pattern.compile(EXPRESSION_REGEX);
        Matcher matcher = pattern.matcher(expressionString);
        while (matcher.find()) {
            expression.add(matcher.group());
        }
        StringBuilder result = new StringBuilder();
        Deque<String> deque = new ArrayDeque<>();
        for (String operand : expression) {
            if ("(".equals(operand)) {
                deque.push(operand);
                continue;
            }
            if (")".equals(operand)) {
                while (!"(".equals(deque.peek())) {
                    result.append(deque.pop()).append(" ");
                }
                deque.pop();
                continue;
            }
            if (priority.containsKey(operand)) {
                while (!deque.isEmpty() && priority.get(operand)
                        <= priority.get(deque.peek())) {
                    result.append(deque.pop()).append(" ");
                }
                deque.push(operand);
                continue;
            }
            if (isNumber(operand)) {
                result.append(operand).append(" ");
                continue;
            }
            throw new IllegalArgumentException();
        }
        while (!deque.isEmpty()) {
            result.append(deque.pop()).append(" ");
        }
        return result.toString().trim();
    }

    /**
     * This method check the string whether it is a number.
     *
     * @param number number
     * @return result
     */
    private boolean isNumber(final String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            LOGGER.error("Not a number " + number, e);
            return false;
        }
    }
}
