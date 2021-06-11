package com.again.visitor;

public class Student extends User{

    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Vistior vistior) {
        vistior.visit(this);
    }

    public int ranking(){
        return (int) (Math.random() * 100);
    }
}
