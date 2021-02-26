package com.fh.combined.company;

public class Employee extends HumanResource {

    public Employee(long id,double salary){
        super(id);
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return 0;
    }
}
