package by.korolenko.composite.service.interpreter;

import by.korolenko.composite.service.interpreter.nonterminal.NonTerminalExpression;
import by.korolenko.composite.service.interpreter.terminal.TerminalExpressionLeftShift;
import by.korolenko.composite.service.interpreter.terminal.TerminalExpressionLogicAnd;
import by.korolenko.composite.service.interpreter.terminal.TerminalExpressionLogicOr;
import by.korolenko.composite.service.interpreter.terminal.TerminalExpressionRightShift;
import by.korolenko.composite.service.interpreter.terminal.TerminalExpressionShiftWithNull;
import by.korolenko.composite.service.interpreter.terminal.TerminalExpressionTilde;
import by.korolenko.composite.service.interpreter.terminal.TerminalExpressionXOR;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class ExpressionParser {
    /**
     * The list of expressions.
     */
    private List<AbstractExpression> expressionList;

    /**
     * Space.
     */
    private static final String SPACE = " ";

    /**
     * Constructor.
     *
     * @param expression expression
     */
    public ExpressionParser(final String expression) {
        expressionList = new ArrayList<>();
        parse(expression);
    }

    private void parse(final String expression) {
        String[] data = expression.split(SPACE);
        for (String operand : data) {
            switch (operand) {
                case "~":
                    expressionList.add(new TerminalExpressionTilde());
                    break;
                case ">>>":
                    expressionList.
                            add(new TerminalExpressionShiftWithNull());
                    break;
                case ">>":
                    expressionList.add(new TerminalExpressionRightShift());
                    break;
                case "<<":
                    expressionList.add(new TerminalExpressionLeftShift());
                    break;
                case "|":
                    expressionList.add(new TerminalExpressionLogicOr());
                    break;
                case "&":
                    expressionList.add(new TerminalExpressionLogicAnd());
                    break;
                case "^":
                    expressionList.add(new TerminalExpressionXOR());
                    break;
                default:
                    expressionList.add(new NonTerminalExpression(
                            Integer.parseInt(operand)));
            }
        }
    }

    /**
     * This method calculates the expression.
     *
     * @return result number
     */
    public Integer calculate() {
        Context context = new Context();
        for (AbstractExpression expression : expressionList) {
            expression.interpret(context);
        }
        return context.popValue();
    }
}
