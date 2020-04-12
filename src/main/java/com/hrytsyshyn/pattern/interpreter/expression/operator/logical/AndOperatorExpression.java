package com.hrytsyshyn.pattern.interpreter.expression.operator.logical;

import com.hrytsyshyn.pattern.interpreter.expression.LogicalExpression;

public class AndOperatorExpression extends LogicalOperatorExpression {

    public AndOperatorExpression(LogicalExpression rightExpression, LogicalExpression leftExpression) {
        super(rightExpression, leftExpression);
    }

    @Override
    protected String getOperator() {
        return "AND";
    }
}
