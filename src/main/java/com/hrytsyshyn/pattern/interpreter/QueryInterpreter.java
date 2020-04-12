package com.hrytsyshyn.pattern.interpreter;

import com.hrytsyshyn.pattern.interpreter.expression.LogicalExpression;
import com.hrytsyshyn.pattern.interpreter.expression.operand.FieldExpression;
import com.hrytsyshyn.pattern.interpreter.expression.operand.ValueExpression;
import com.hrytsyshyn.pattern.interpreter.expression.operator.comparison.ComparisonOperatorExpression;
import com.hrytsyshyn.pattern.interpreter.expression.operator.comparison.EqualsOperatorExpression;
import com.hrytsyshyn.pattern.interpreter.expression.operator.logical.AndOperatorExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryInterpreter {

    private static final Pattern EQUALS_OPERATOR_PATTERN = Pattern.compile("(.*)(==)(.*)");
    private static final Pattern LOGICAL_CHUNKS_PATTERN = Pattern.compile("[^\\&\\&]+");

    public String interpret(String query) {
        return parseToLogicalExpression(query).interpret();
    }

    private LogicalExpression parseToLogicalExpression(String query) {
        Matcher conditionalExpressionMatcher = LOGICAL_CHUNKS_PATTERN.matcher(query);

        ComparisonOperatorExpression comparisonExpression = getComparisonExpression(conditionalExpressionMatcher);

        String remainingString = query.substring(conditionalExpressionMatcher.end());

        if (remainingString.isEmpty()) {
            return comparisonExpression;
        } else {
            return new AndOperatorExpression(
                    comparisonExpression,
                    parseToLogicalExpression(remainingString)
            );
        }
    }

    private ComparisonOperatorExpression getComparisonExpression(Matcher matcher) {
        if (matcher.find()) {
            String conditionalExpression = matcher.group();
            Matcher equalsOperationMatcher = EQUALS_OPERATOR_PATTERN.matcher(conditionalExpression);
            if (equalsOperationMatcher.find()) {
                return new EqualsOperatorExpression(
                        new FieldExpression(getLeftOperand(equalsOperationMatcher)),
                        new ValueExpression(getRightOperand(equalsOperationMatcher)));
            }
        }
        return null;
    }

    private String getLeftOperand(Matcher equalsOperationMatcher) {
        return equalsOperationMatcher.group(1);
    }

    private String getRightOperand(Matcher equalsOperationMatcher) {
        return equalsOperationMatcher.group(3);
    }
}
