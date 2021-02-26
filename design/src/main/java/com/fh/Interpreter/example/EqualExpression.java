package com.fh.Interpreter.example;

import java.util.Map;

public class EqualExpression implements Expression {

    private String key;
    private long value;

    public EqualExpression(String strExpression){
        String[] elements = strExpression.trim().split("\\s+");
        if(elements.length != 3 || !elements[1].trim().equals(">")){
            throw new RuntimeException("");
        }
        this.key = elements[0];
        this.value = Long.parseLong(elements[2]);
    }

    public EqualExpression(String key, long value){
        this.key = key;
        this.value = value;
    }


    @Override
    public boolean interpret(Map<String, Long> stats) {
        if(!stats.containsKey(key)){
            return false;
        }
        Long aLong = stats.get(key);
        return aLong == value;
    }
}
