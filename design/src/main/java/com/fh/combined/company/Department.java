package com.fh.combined.company;

import java.util.ArrayList;
import java.util.List;

public class Department extends HumanResource {

    private List<HumanResource> subNodes = new ArrayList<>();

    protected Department(long id) {
        super(id);
    }

    @Override
    public double calculateSalary() {
        int totalSalary = 0;
        for (HumanResource subNode : subNodes) {
            totalSalary += subNode.calculateSalary();
        }
        this.salary = totalSalary;
        return totalSalary;
    }

    public void addSubNode(HumanResource resource){
        this.subNodes.add(resource);
    }
}
