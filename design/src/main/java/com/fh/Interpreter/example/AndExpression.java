package com.fh.Interpreter.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AndExpression implements Expression {

    private List<Expression> expressions = new ArrayList<>();

    public AndExpression(String strAndExpression){
        String[] elements = strAndExpression.trim().split("&&");
        for (String element : elements) {
            if(element.contains(">")){
                expressions.add(new GreaterExpression(element));
            }else if(element.contains("<")){
                expressions.add(new LessExpression(element));
            }else if(element.contains("==")){
                expressions.add(new EqualExpression(element));
            }else {
                throw new RuntimeException("");
            }
        }

    }

    public AndExpression(List<Expression> expressions){
        this.expressions.addAll(expressions);
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        for (Expression expression : expressions) {
            if(!expression.interpret(stats)){
                return false;
            }
        }
        return true;
    }
}
