package com.hrytsyshyn.pattern.interpreter;

import com.hrytsyshyn.pattern.interpreter.expression.operand.FieldExpression;
import com.hrytsyshyn.pattern.interpreter.expression.operand.ValueExpression;
import com.hrytsyshyn.pattern.interpreter.expression.operator.comparison.EqualsOperatorExpression;
import com.hrytsyshyn.pattern.interpreter.expression.operator.logical.AndOperatorExpression;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryInterpreterTest {

    private QueryInterpreter underTest = new QueryInterpreter();

    @Test
    public void interpretStringQuery() {
        String testQuery = "placesCount==10&&skiLevel==BEGINNER&&price==1000";

        String actualSqlQuery = underTest.interpret(testQuery);

        assertEquals(actualSqlQuery, "placesCount=10 AND skiLevel='BEGINNER' AND price=1000");
    }

    @Test
    public void interpretExpressionTree() {
        //[(placesCount==10) && (skiLevel==BEGINNER)] && [price==1000]

        AndOperatorExpression underTest = new AndOperatorExpression(
                squareBrackets(),
                new EqualsOperatorExpression(
                        new FieldExpression("price"),
                        new ValueExpression(1000)) {
                });

        String actualSqlQuery = underTest.interpret();

        assertEquals(actualSqlQuery, "placesCount=10 AND skiLevel='BEGINNER' AND price=1000");
    }

    private AndOperatorExpression squareBrackets() {
        return new AndOperatorExpression(
                new EqualsOperatorExpression(
                        new FieldExpression("placesCount"),
                        new ValueExpression(10)),

                new EqualsOperatorExpression(
                        new FieldExpression("skiLevel"),
                        new ValueExpression("BEGINNER"))
        );
    }
}