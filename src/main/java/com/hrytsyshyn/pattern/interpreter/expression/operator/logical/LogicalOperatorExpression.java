package com.hrytsyshyn.pattern.interpreter.expression.operator.logical;

import com.hrytsyshyn.pattern.interpreter.expression.LogicalExpression;

public abstract class LogicalOperatorExpression implements LogicalExpression {

    private LogicalExpression rightExpression;
    private LogicalExpression leftExpression;

    public LogicalOperatorExpression(LogicalExpression rightExpression,
                                     LogicalExpression leftExpression) {
        this.rightExpression = rightExpression;
        this.leftExpression = leftExpression;
    }

    @Override
    public String interpret() {
        return rightExpression.interpret() + " " + getOperator() + " " + leftExpression.interpret();
    }

    protected abstract String getOperator();
}
