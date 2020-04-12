package com.hrytsyshyn.pattern.interpreter.expression.operator.comparison;

import com.hrytsyshyn.pattern.interpreter.expression.operand.OperandExpression;
import com.hrytsyshyn.pattern.interpreter.expression.LogicalExpression;
import com.hrytsyshyn.pattern.interpreter.expression.operator.BinaryOperatorExpression;

public abstract class ComparisonOperatorExpression extends BinaryOperatorExpression implements LogicalExpression {

    public ComparisonOperatorExpression(OperandExpression rightOperand, OperandExpression leftOperand) {
        super(rightOperand, leftOperand);
    }
}
