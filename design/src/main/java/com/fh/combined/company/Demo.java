package com.fh.combined.company;

import java.util.List;

public class Demo {

    private static final long ORGANIZATION_ROOT_ID = 1001;

    private DepartmentRepo departmentRepo;

    private EmployeeRepo employeeRepo;

    public void buildOrganization(){
        Department department = new Department(ORGANIZATION_ROOT_ID);
        buildOrganization(department);
    }

    public void buildOrganization(Department department){
        List<Long> subDepartmentIds = departmentRepo.getSubDepartmentIds(department.getId());
        for (Long subDepartmentId : subDepartmentIds) {
            Department department1  = new Department(subDepartmentId);
            department.addSubNode(department1);
            buildOrganization(department1);
        }

        List<Long> departmentEmployeeIds = employeeRepo.getDepartmentEmployeeIds(department.getId());
        for (Long departmentEmployeeId : departmentEmployeeIds) {
            double employeeSalary = employeeRepo.getEmployeeSalary(departmentEmployeeId);
            department.addSubNode(new Employee(departmentEmployeeId,employeeSalary));
        }
    }
}
