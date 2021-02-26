package com.fh.combined.company;

public abstract class HumanResource {

    protected long id;

    protected double salary;

    protected HumanResource(long id){
        this.id = id;
    }

    public long getId(){
        return this.id;
    }

    public abstract double calculateSalary();
}
