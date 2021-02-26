package com.fh.Interpreter.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrExpression implements Expression {


    private List<Expression> expressions = new ArrayList<>();

    public OrExpression(String strOrExpression){
        String[] elements = strOrExpression.split("\\|\\|");
        for (String element : elements) {
            expressions.add(new AndExpression(element));
        }
    }

    public OrExpression(List<Expression> expressions){
        this.expressions.addAll(expressions);
    }


    @Override
    public boolean interpret(Map<String, Long> stats) {
        for (Expression expression : expressions) {
            if(expression.interpret(stats)){
                return true;
            }
        }
        return false;
    }
}
