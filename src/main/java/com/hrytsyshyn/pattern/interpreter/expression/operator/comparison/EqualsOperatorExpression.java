package com.hrytsyshyn.pattern.interpreter.expression.operator.comparison;

import com.hrytsyshyn.pattern.interpreter.expression.operand.OperandExpression;

public class EqualsOperatorExpression extends ComparisonOperatorExpression {

    public EqualsOperatorExpression(OperandExpression rightOperand, OperandExpression leftOperand) {
        super(rightOperand, leftOperand);
    }

    @Override
    public String interpret() {
        return rightOperand.interpret() + "=" + leftOperand.interpret();
    }
}
