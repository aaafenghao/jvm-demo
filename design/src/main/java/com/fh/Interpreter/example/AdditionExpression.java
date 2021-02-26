package com.fh.Interpreter.example;

import com.fh.Interpreter.Expression;

public class AdditionExpression implements Expression {

    private Expression expression1;
    private Expression expression2;

    public AdditionExpression(Expression expression1,Expression expression2){
        this.expression1 = expression1;
        this.expression2 = expression2;
    }


    @Override
    public long interpret() {
        return expression1.interpret() + expression2.interpret();
    }
}
