package com.fh.Interpreter;

import com.fh.Interpreter.example.AdditionExpression;

import java.util.Deque;
import java.util.LinkedList;

public class ExpressionInterpreter1 {

    private Deque<Expression> numbers = new LinkedList<>();

    public long interpret(String expression){
        String[] elements = expression.split(" ");

        int length = elements.length;
        for (int i = 0; i < (length+1)/2; i++) {
            numbers.add(new NumberExpression(elements[i]));
        }
        for (int i = (length+1)/2; i < length; i++) {
            String operator = elements[i];
            boolean isValid = "+".equals(operator) || "-".equals(operator) || "*".equals(operator) || "/".equals(operator);
            if (!isValid) {
                throw new RuntimeException("Expression is invalid: " + expression);
            }
            Expression expression1 = numbers.pollFirst();
            Expression expression2 = numbers.pollFirst();
            Expression combie = null;
            if(operator.equals("+")){
                combie = new AdditionExpression(expression1,expression2);
            }else if(operator.equals("-")){
                combie = new SubstractionExpression(expression1,expression2);
            }else if(operator.equals("*")){
                combie = new MultiplicationExpression(expression1,expression2);
            }else if(operator.equals("/")){
                combie = new DivisionExpression(expression1,expression2);
            }
            long result = combie.interpret();
            numbers.addFirst(new NumberExpression(result));
        }
        if(numbers.size() != 1){
            throw new RuntimeException("");
        }
        return numbers.pop().interpret();
    }
}
