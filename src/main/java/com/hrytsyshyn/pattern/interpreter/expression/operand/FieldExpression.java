package com.hrytsyshyn.pattern.interpreter.expression.operand;

import com.hrytsyshyn.pattern.interpreter.expression.operand.OperandExpression;

public class FieldExpression implements OperandExpression {

    private String field;

    public FieldExpression(String field) {
        this.field = field;
    }

    @Override
    public String interpret() {
        return field;
    }
}