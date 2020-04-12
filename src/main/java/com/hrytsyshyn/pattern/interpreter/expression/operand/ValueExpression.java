package com.hrytsyshyn.pattern.interpreter.expression.operand;

import com.hrytsyshyn.pattern.interpreter.expression.operand.OperandExpression;
import org.apache.commons.lang3.math.NumberUtils;

public class ValueExpression implements OperandExpression {

    private Object value;

    public ValueExpression(Object value) {
        this.value = value;
    }

    @Override
    public String interpret() {
        if (NumberUtils.isParsable(value.toString())) {
            return value.toString();
        }
        return "'" + value + "'";
    }
}
