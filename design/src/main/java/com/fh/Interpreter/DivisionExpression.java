package com.fh.Interpreter;

public class DivisionExpression implements Expression{

    private Expression expression1;
    private Expression expression2;

    public DivisionExpression(Expression expression1,Expression expression2){
        this.expression1 = expression1;
        this.expression2 = expression2;
    }


    @Override
    public long interpret() {
        return expression1.interpret() / expression2.interpret();
    }
}
