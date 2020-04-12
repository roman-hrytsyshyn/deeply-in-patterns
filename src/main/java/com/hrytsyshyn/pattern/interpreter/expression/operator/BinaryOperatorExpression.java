package com.hrytsyshyn.pattern.interpreter.expression.operator;

import com.hrytsyshyn.pattern.interpreter.expression.operand.OperandExpression;
import com.hrytsyshyn.pattern.interpreter.expression.Expression;

public abstract class BinaryOperatorExpression implements Expression {

    protected OperandExpression rightOperand;
    protected OperandExpression leftOperand;

    public BinaryOperatorExpression(OperandExpression rightOperand, OperandExpression leftOperand) {
        this.rightOperand = rightOperand;
        this.leftOperand = leftOperand;
    }

    @Override
    public String interpret() {
        return rightOperand.interpret() + leftOperand.interpret();
    }
}
