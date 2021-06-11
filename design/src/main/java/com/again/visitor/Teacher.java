package com.again.visitor;

import java.math.BigDecimal;

public class Teacher extends User{

    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Vistior vistior) {
        vistior.visit(this);
    }

    public double entranceRaio(){
        return BigDecimal.valueOf(Math.random() * 100).setScale(2,
                BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
